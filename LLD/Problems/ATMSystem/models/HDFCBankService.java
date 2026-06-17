package LLD.Problems.ATMSystem.models;

public class HDFCBankService extends BankService {
  public HDFCBankService() {
    super();
  }

  public boolean authenticate(String cardNo) {
    if(!cardNo.contains(cardNo) || !cardToAccountMap.containsKey(cardNo) || !accounts.containsKey(cardToAccountMap.get(cardNo))) return false;
    return true;
  }

  public void initWithdrawal(String cardNo, int debitAmount) {
    String linkedAccountNo = cardToAccountMap.get(cardNo);
    Account linkedAccount = accounts.get(linkedAccountNo);

    linkedAccount.withdraw(debitAmount);
  }

  public void initDeposit(String cardNo, int creditAmount) {
    String linkedAccountNo = cardToAccountMap.get(cardNo);
    Account linkedAccount = accounts.get(linkedAccountNo);

    linkedAccount.deposit(creditAmount);
  }

  public long getBalance(String cardNo) {
    String linkedAccountNo = cardToAccountMap.get(cardNo);
    Account linkedAccount = accounts.get(linkedAccountNo);

    long balance = linkedAccount.getBalance();
    return balance;
  }

  public void addAccount(String accountNo) {
    Account account = new Account(accountNo, this);
    accounts.put(accountNo, account);
  }

  public void createATMCard(String cardNo, String pin, String accountNo) {
    ATMCard card = new ATMCard(cardNo, pin, this);
    cards.put(cardNo, card);
    cardToAccountMap.put(cardNo, accountNo);
  }

  @Override
  public void update(String message) {
    System.out.println("[UPDATE HDFC BANK]: " + message);
  }
}
