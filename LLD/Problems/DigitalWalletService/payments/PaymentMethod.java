package LLD.Problems.DigitalWalletService.payments;

import java.math.BigDecimal;

import LLD.Problems.DigitalWalletService.enums.Currency;
import LLD.Problems.DigitalWalletService.models.User;

public abstract class PaymentMethod {
  protected String payId;
  protected User user;
  
  protected PaymentMethod(String id, User user) {
    payId = id;
    this.user = user;
  }
  public abstract void processPayment(BigDecimal amount, Currency currency);
}
