package LLD.Problems.CarRentalSystem.models;

import LLD.Problems.CarRentalSystem.enums.CarType;

public class SUVCar extends Car {
  private double PRICE_MULTIPLIER = 3.5;
  public SUVCar(String id, String model, String plateNo, CarType type, int year) {
    super(id, model, plateNo, type, year);
  }

  @Override
  public double calculateTotalPrice(int duration) {
    return duration * baseRentalPricePerDay * PRICE_MULTIPLIER;
  }
}
