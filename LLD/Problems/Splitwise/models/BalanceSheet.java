package LLD.Problems.Splitwise.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
  private Map<UserPair, Double> balances;

  public BalanceSheet() {
    balances = new HashMap<>();
  }

  public void updateBalance(Expense expense) {
    Map<User, Double> splits = expense.getSplits();
    User paidBy = expense.getPaidBy();

    for(Map.Entry<User, Double> split: splits.entrySet()) {
      User givesBack = split.getKey();
      double amount = split.getValue();

      if(!givesBack.equals(paidBy)) {
        UserPair userPair = new UserPair(givesBack, paidBy);
        balances.put(userPair, balances.getOrDefault(userPair, 0.0) + amount);
      }
    }
  }

  public double getBalanceBetweenTwoUser(User user1, User user2) {
    UserPair pairFrom1to2 = new UserPair(user1, user2);
    UserPair pairFrom2to1 = new UserPair(user2, user1);

    double balanceFrom1to2 = balances.getOrDefault(pairFrom1to2, 0.0);
    double balanceFrom2to1 = balances.getOrDefault(pairFrom2to1, 0.0);

    return balanceFrom1to2 - balanceFrom2to1;
  }

  public double getTotalBalance(User user) {
    double userBalance = 0.0;

    for(Map.Entry<UserPair, Double> balance: balances.entrySet()) {
      if(balance.getKey().getReceiver().equals(user)) {
        userBalance += balance.getValue();
      } else if(balance.getKey().getPayer().equals(user)) {
        userBalance -= balance.getValue();
      }
    }

    return userBalance;
  }

  public List<Transaction> naive2PointerWrongApproach() {
    Map<User, Double> netBalances = new HashMap<>();

    for(Map.Entry<UserPair, Double> balance: balances.entrySet()) {
      User givesBack = balance.getKey().getPayer();
      User getsBack = balance.getKey().getReceiver();
      double amount = balance.getValue();

      netBalances.put(givesBack, netBalances.getOrDefault(givesBack, 0.0) - amount);
      netBalances.put(getsBack, netBalances.getOrDefault(getsBack, 0.0) + amount);
    }
    List<User> debtors = new ArrayList<>();
    List<User> creditors = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    for(Map.Entry<User, Double> user: netBalances.entrySet()) {
      if(user.getValue() > 0) creditors.add(user.getKey());
      else if(user.getValue() < 0) debtors.add(user.getKey());
    }

    int debtorIndex = 0, creditorIndex = 0;

    while(debtorIndex < debtors.size() && creditorIndex < creditors.size()) {
      User debtor = debtors.get(debtorIndex);
      User creditor = creditors.get(creditorIndex);
      double debtorBalance = netBalances.get(debtor);
      double creditorBalance = netBalances.get(creditor);

      // Determine the transfer amount as the smaller of the two balances
      double transferAmount = Math.min(Math.abs(debtorBalance), creditorBalance);

      // Create a transaction for the transfer amount
      transactions.add(new Transaction(debtor, creditor, transferAmount));

      // Update net balances after the transaction
      netBalances.put(debtor, debtorBalance + transferAmount);
      netBalances.put(creditor, creditorBalance - transferAmount);

      // Move to the next debtor or creditor if their balance is settled
      if (Math.abs(netBalances.get(debtor)) < 0.001) {
        debtorIndex++;
      }
      if (Math.abs(netBalances.get(creditor)) < 0.001) {
        creditorIndex++;
      }
    }

    return transactions;
  }

  public List<Transaction> backtrackingApproach() {
    // O(n!)
    Map<User, Double> netBalances = new HashMap<>();

    for(Map.Entry<UserPair, Double> balance: balances.entrySet()) {
      User givesBack = balance.getKey().getPayer();
      User getsBack = balance.getKey().getReceiver();
      double amount = balance.getValue();

      netBalances.put(givesBack, netBalances.getOrDefault(givesBack, 0.0) - amount);
      netBalances.put(getsBack, netBalances.getOrDefault(getsBack, 0.0) + amount);
    }

    List<User> allUsers = new ArrayList<>();
    List<Double> creditList = new ArrayList<>();
    for(Map.Entry<User, Double> user: netBalances.entrySet()) {
      creditList.add(user.getValue());
      allUsers.add(user.getKey());
    }
    List<Transaction> currentTransactionsList = new ArrayList<>();
    List<Transaction> minTransactions = new ArrayList<>();

    recc(0, creditList.size(), creditList, allUsers, currentTransactionsList, minTransactions);

    return minTransactions;
  }

  private void recc(int idx, int n, List<Double> creditList, List<User> allUsers, List<Transaction> currentTransactionsList, List<Transaction> minTransactions) {
    while(idx < n && creditList.get(idx) < 0.001) {
      idx++;
    }

    if(idx == n) {
      if(minTransactions.size() == 0) {
        for(Transaction transaction: currentTransactionsList) {
          minTransactions.add(transaction);
        }
      } else if(currentTransactionsList.size() < minTransactions.size()) {
        minTransactions.clear();
        for(Transaction transaction: currentTransactionsList) {
          minTransactions.add(transaction);
        }
      }
      return;
    }

    for(int nextIdx = idx + 1; nextIdx < creditList.size(); nextIdx++) {
      // try settling current user with next index, give all current funds to next index, no matter + or -, basically make a transaction between them
      // by settling current one to zero 
      if((creditList.get(idx) * creditList.get(nextIdx)) < 0) {
        // then only makes sense for a transaction between them
        if(creditList.get(idx) < 0) {
          currentTransactionsList.add(new Transaction(allUsers.get(idx), allUsers.get(nextIdx), Math.abs(creditList.get(idx)))); // whole amount he gave to next positive guy
          // by idx++ we are ensuring effectively we did credList.set(idx) = 0;
        } else {
          currentTransactionsList.add(new Transaction(allUsers.get(nextIdx), allUsers.get(idx), creditList.get(idx)));
        }

        creditList.set(nextIdx, creditList.get(nextIdx) + creditList.get(idx));
        
        recc(idx + 1, n, creditList, allUsers, currentTransactionsList, minTransactions);
        
        creditList.set(nextIdx, creditList.get(nextIdx) - creditList.get(idx));

        currentTransactionsList.removeLast();
      }
    }
  }

  public int dpBitmaskOptimalApproach() {
    // O(n*2^n) as of now just min number of transactions
    Map<User, Double> netBalances = new HashMap<>();

    for(Map.Entry<UserPair, Double> balance: balances.entrySet()) {
      User givesBack = balance.getKey().getPayer();
      User getsBack = balance.getKey().getReceiver();
      double amount = balance.getValue();

      netBalances.put(givesBack, netBalances.getOrDefault(givesBack, 0.0) - amount);
      netBalances.put(getsBack, netBalances.getOrDefault(getsBack, 0.0) + amount);
    }

    List<User> allUsers = new ArrayList<>();
    List<Double> creditList = new ArrayList<>();
    for(Map.Entry<User, Double> user: netBalances.entrySet()) {
      creditList.add(user.getValue());
      allUsers.add(user.getKey());
    }

    int totalMembers = allUsers.size();
    int[] dp = new int[1 << totalMembers];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    int maxGrps = reccDP((1 << totalMembers) - 1, totalMembers, creditList, dp);
    
    return totalMembers - maxGrps;
  }

  private boolean checkSum(int subGrp, List<Double> creditList) {
    double sum = 0.0;

    for(int i = 0; i < creditList.size(); i++) {
      if((subGrp & (1 << i)) > 0) {
        sum += creditList.get(i);
      }
    }

    if(Math.abs(sum) < 0.001) return true;
    return false;
  } 

  private int reccDP(int availableGrp, int totalMembers, List<Double> credList, int[] dp) {
    if(availableGrp == 0) return 0;
    if(dp[availableGrp] != -1) return dp[availableGrp];

    int grps = Integer.MIN_VALUE;

    for(int subGrp = 1; subGrp < (1 << totalMembers); subGrp++) {
      if((subGrp & availableGrp) == subGrp && checkSum(subGrp, credList)) {
        grps = Math.max(grps, 1 + reccDP(subGrp, totalMembers, credList, dp));
      }
    }
    dp[availableGrp] = grps;
    return grps;
  }
}


