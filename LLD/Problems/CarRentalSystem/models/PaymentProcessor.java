package LLD.Problems.CarRentalSystem.models;

import LLD.Problems.CarRentalSystem.strategy.PaymentStrategy;

public class PaymentProcessor {
  public void processPayment(double amount, PaymentStrategy strategy) {
    strategy.handlePayment(amount);
  }
}
