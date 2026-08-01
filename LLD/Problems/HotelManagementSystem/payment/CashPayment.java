package LLD.Problems.HotelManagementSystem.payment;

public class CashPayment implements Payment {
  @Override
  public boolean processPayment(double amount) {
    // Process credit card payment
    return true;
  }
}
