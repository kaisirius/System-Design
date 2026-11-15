package LLD.Problems.Splitwise.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ExpenseGroup {
  private final String groupId;
  private String groupName;
  private Set<User> members;
  private List<Expense> expenseHistory;
  private final BalanceSheet balanceSheet;

  public ExpenseGroup(String name) {
    groupId = UUID.randomUUID().toString();
    groupName = name;
    members = new HashSet<>();
    expenseHistory = new ArrayList<>();
    balanceSheet = new BalanceSheet();
  }

  public void addExpense(Expense expense) {
    expenseHistory.add(expense);
    balanceSheet.updateBalance(expense);
  }

  public void addGroupMember(User member) {
    members.add(member);
  }

  public double getBalanceForGroupMember(User user) {
    return balanceSheet.getTotalBalance(user);
  }

  public BalanceSheet getBalanceSheet() {
    return balanceSheet;
  }

  public Set<User> getGroupMembers() {
    return members;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupId() {
    return groupId;
  }
}
