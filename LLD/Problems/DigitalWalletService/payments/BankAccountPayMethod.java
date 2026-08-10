package LLD.Problems.DigitalWalletService.payments;

import java.math.BigDecimal;
import java.util.UUID;

import LLD.Problems.DigitalWalletService.enums.Currency;
import LLD.Problems.DigitalWalletService.models.User;

public class BankAccountPayMethod extends PaymentMethod {
  private String accNo;
  private String phoneNo;

  public BankAccountPayMethod(User user, String accNo, String phoneNo) {
    super(UUID.randomUUID().toString(), user);
    this.accNo = accNo;
    this.phoneNo = phoneNo;
  }

  public void processPayment(BigDecimal amount, Currency currency) {
    // process payment
  }
}
