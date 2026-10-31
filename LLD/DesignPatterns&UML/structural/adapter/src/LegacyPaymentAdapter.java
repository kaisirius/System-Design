public class LegacyPaymentAdapter {
  private LegacyPaymentService service;

  public LegacyPaymentAdapter() {
    service = new LegacyPaymentService();
  }

  public void processPayment(double rupees) {
    double paise = rupees * 100.0;
    service.makePaymentInPaise(paise);
  }
}
