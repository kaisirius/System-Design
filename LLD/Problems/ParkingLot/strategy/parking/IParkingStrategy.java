package LLD.Problems.ParkingLot.strategy.parking;

import java.util.List;

import LLD.Problems.ParkingLot.models.ParkingFloor;
import LLD.Problems.ParkingLot.models.ParkingSpot;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public interface IParkingStrategy {
  public ParkingSpot getParkingSpot(List<ParkingFloor> floors, Vehicle vehicle); 
}
