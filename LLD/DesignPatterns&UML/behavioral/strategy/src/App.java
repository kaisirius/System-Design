public class App {
    public static void main(String[] args) throws Exception {
        IPaymentStrategy strategy = new CreditCardPaymentStrategy();
        strategy.processPayment(10000);
        // setting new strategy
        strategy = new UPIPaymentStrategy();
        strategy.processPayment(500);
    }
}
