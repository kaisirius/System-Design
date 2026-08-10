package LLD.Problems.DigitalWalletService.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import LLD.Problems.DigitalWalletService.enums.*;


public class Transaction {
  private String transactionId;
  private Account sourceAcc;
  private Account destAccount;
  private TransactionType transactionType;
  private BigDecimal amount;
  private Currency currency;
  private LocalDateTime timestamp;

  public Transaction(BigDecimal amount, Account source, Account dest, TransactionType type, Currency currency) {
    transactionId = UUID.randomUUID().toString();
    sourceAcc = source;
    destAccount = dest;
    transactionType = type; 
    this.amount = amount;
    this.currency = currency;
    timestamp = LocalDateTime.now();
  }

  // have getters and setters , do whatever you want to do further. access transaction via account's transaction history
}
