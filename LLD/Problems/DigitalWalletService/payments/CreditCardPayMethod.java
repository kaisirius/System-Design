package LLD.Problems.DigitalWalletService.payments;

import java.math.BigDecimal;
import java.util.UUID;

import LLD.Problems.DigitalWalletService.enums.Currency;
import LLD.Problems.DigitalWalletService.models.User;

public class CreditCardPayMethod extends PaymentMethod {
  private String cardNo;
  private String cvv;
  private String expiry;

  public CreditCardPayMethod(User user, String cardNo, String cvv, String expiry) {
    super(UUID.randomUUID().toString(), user);
    this.cardNo = cardNo;
    this.cvv = cvv;
    this.expiry = expiry;
  }

  public void processPayment(BigDecimal amount, Currency currency) {
    // process payment
  }
}
