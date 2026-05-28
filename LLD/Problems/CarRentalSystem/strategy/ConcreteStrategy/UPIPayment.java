package LLD.Problems.CarRentalSystem.strategy.ConcreteStrategy;

import LLD.Problems.CarRentalSystem.strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
  @Override
  public void handlePayment(double amount) {
    System.out.println("Payment of : " + amount + " done using UPI");
  }
}
