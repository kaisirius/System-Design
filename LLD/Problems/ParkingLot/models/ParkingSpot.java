package LLD.Problems.ParkingLot.models;

import LLD.Problems.ParkingLot.enums.Size;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public class ParkingSpot {
  private Size allowedSize;
  private String allowedVehicleType;
  private boolean occupied;
  private Vehicle parkedVehicle;
  private int spotId;
  private static int idIncrementor = 1;

  public ParkingSpot(Size size, String type) {
    allowedSize = size;
    allowedVehicleType = type;
    occupied = false;
    spotId = idIncrementor++;
    parkedVehicle = null;
  }

  public void parkVehicle(Vehicle vehicle) {
    occupied = true;
    parkedVehicle = vehicle;
  }

  public boolean isOccupied() {
    return occupied;
  } 

  public void unparkVehicle() {
    occupied = false;
    parkedVehicle = null;
  }

  public boolean canFitVehicle(Vehicle vehicle) {
    if(vehicle.getSize() == allowedSize && vehicle.getType() == allowedVehicleType) {
      return true;
    } 
    return false;
  }

  // GETTERS
  public Size getAllowedSize() {
    return allowedSize;
  }

  public String getAllowedType() {
    return allowedVehicleType;
  }

  public int getSpotId() {
    return spotId;
  }

}
