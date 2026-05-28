package LLD.Problems.CarRentalSystem.models;

import LLD.Problems.CarRentalSystem.enums.CarType;

public abstract class Car {
  protected String id;
  protected String model;
  protected String plateNo;
  protected CarType type;
  protected int year;
  protected double baseRentalPricePerDay = 1000;
  protected boolean isUnderMaintenance = false;

  public Car(String id, String model, String plateNo, CarType type, int year) {
    this.id = id;
    this.model = model;
    this.plateNo = plateNo;
    this.type = type;
    this.year = year;
  }

  public void setMaintenance(boolean flag) {
    isUnderMaintenance = flag;
  }

  public abstract double calculateTotalPrice(int duration);
  
  // NECESSARY GETTERS
  public String getId() {
    return id;
  }
  
}
