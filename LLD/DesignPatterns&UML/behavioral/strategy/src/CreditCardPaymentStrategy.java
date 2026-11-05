public class CreditCardPaymentStrategy implements IPaymentStrategy {
  public void processPayment(double amount) {
    System.out.println("Amount paid using credit card: " + amount);
  }
}
