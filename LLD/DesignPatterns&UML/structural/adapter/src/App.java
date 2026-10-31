public class App {
    public static void main(String[] args) throws Exception {
        LegacyPaymentAdapter paymentAdapter = new LegacyPaymentAdapter();
        paymentAdapter.processPayment(99);
    }
}
