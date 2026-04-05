package LLD.Problems.ParkingLot.strategy.parking;

import java.util.ArrayList;
import java.util.List;

import LLD.Problems.ParkingLot.models.ParkingFloor;
import LLD.Problems.ParkingLot.models.ParkingSpot;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public class FirstFindParkingStrategy implements IParkingStrategy {
  @Override
  public ParkingSpot getParkingSpot(List<ParkingFloor> floors, Vehicle vehicle) {
    List<ParkingSpot> freeSpots = new ArrayList<>(); 

    for(ParkingFloor floor: floors) {
       List<ParkingSpot> currentFloorSpots = floor.getAllAvailableSpots(vehicle);
       for(ParkingSpot spot : currentFloorSpots) {
        freeSpots.add(spot);
       }
    }
    return freeSpots.get(0);
  } 
}
