public class UPIPaymentStrategy implements IPaymentStrategy {
  public void processPayment(double amount) {
    System.out.println("Amount paid using UPI: " + amount);
  }
}
