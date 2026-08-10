package LLD.Problems.DigitalWalletService.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import LLD.Problems.DigitalWalletService.payments.PaymentMethod;

public class User {
  private String userId;
  private String name;
  private String email;
  private String panNo;
  private List<Account> accounts;
  private List<PaymentMethod> paymentMethods;

  public User(String name, String email, String panNo) {
    userId = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
    this.panNo = panNo;
    accounts = new ArrayList<>();
    paymentMethods = new ArrayList<>();
  }

  public String getUserId() { 
    return userId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPanNo() {
    return panNo;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public List<PaymentMethod> getPayMethods() {
    return paymentMethods;
  }

  public void addAccount(Account account) {
    accounts.add(account);
  }

  public void addPayMethod(PaymentMethod newPayMethod) {
    paymentMethods.add(newPayMethod);
  }
}
 