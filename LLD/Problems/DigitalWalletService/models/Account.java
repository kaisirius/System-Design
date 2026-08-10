package LLD.Problems.DigitalWalletService.models;

import java.math.BigDecimal;
import java.util.List;

import LLD.Problems.DigitalWalletService.enums.Currency;
import LLD.Problems.DigitalWalletService.exceptions.InsufficientFundException;

public class Account {
  private String transactionId;
  private User user;
  private String accNo;
  private List<Transaction> transHistory;
  private BigDecimal balance;
  private Currency currency;

  // GETTERS & SETTERS 
  public void addTransaction(Transaction transaction) {
    transHistory.add(transaction);
  }

  public List<Transaction> getTransactionHistory() {
    return transHistory;
  }
  // so on and so forth...
  
  public void deposit(BigDecimal amount) {
    balance = balance.add(amount);
  } 

  public void withdraw(BigDecimal amount) {
    if(balance.compareTo(amount) >= 0) 
    balance = balance.subtract(amount);

    else new InsufficientFundException("Insufficient Balance!");
  }

  public Currency getCurrency() {
    return currency;
  }

  
}
