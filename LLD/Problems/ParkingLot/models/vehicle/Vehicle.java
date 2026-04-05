package LLD.Problems.ParkingLot.models.vehicle;

import LLD.Problems.ParkingLot.enums.Size;

public class Vehicle {
  private Size size;
  private String licensePlate;
  private String type;

  public Vehicle(Size size, String licenseNo, String type) {
    this.size = size;
    this.licensePlate = licenseNo;
    this.type = type;
  }

  public Size getSize() {
    return this.size;
  }

  public String getLicensePlate() {
    return this.licensePlate;
  }

  public String getType() {
    return this.type;
  }

}
