package LLD.Problems.ATMSystem.models;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.ATMSystem.observer.ITransactionObserver;

public abstract class BankService implements ITransactionObserver {
  protected Map<String, ATMCard> cards;
  protected Map<String, Account> accounts;
  protected Map<String, String> cardToAccountMap; 

  public BankService() {
    cards = new HashMap<>();
    accounts = new HashMap<>();
    cardToAccountMap = new HashMap<>();
  }

  @Override
  public abstract void update(String message);
  public abstract boolean authenticate(String cardNo);

  public abstract void initWithdrawal(String cardNo, int debitAmount);

  public abstract void initDeposit(String cardNo, int creditAmount);

  public abstract long getBalance(String cardNo);

  public abstract void addAccount(String accountNo);

  public abstract void createATMCard(String cardNo, String pin, String accountNo);
}
