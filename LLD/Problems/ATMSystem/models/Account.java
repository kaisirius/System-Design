package LLD.Problems.ATMSystem.models;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.ATMSystem.observer.ITransactionObserver;

public class Account {
  private String accountNo;
  private long balance;
  private List<ITransactionObserver> observers;

  public Account(String no, BankService service) {
    accountNo = no;
    balance = 0;
    observers = new ArrayList<>();
    observers.add(service);
  }

  public void withdraw(int debitAmount) {
    balance -= debitAmount;
    notifyObserver("Amount debited: " + debitAmount + "in account No: " + accountNo);
  }

  public void deposit(int creditAmount) {
    balance += creditAmount;
    notifyObserver("Amount credited: " + creditAmount + "in account No: " + accountNo);
  }

  public long getBalance() {
    return balance;
  }

  public void notifyObserver(String message) {
    for(ITransactionObserver obs:  observers) {
      obs.update(message);
    }
  }
}
