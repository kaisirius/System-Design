package LLD.Problems.DigitalWalletService.exceptions;

public class InsufficientFundException extends RuntimeException {
  public InsufficientFundException(String msg) {
    super(msg);
  }
}
