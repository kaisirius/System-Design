package LLD.Problems.ParkingLot.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public class ParkingFloor {
  private Map<Integer, ParkingSpot> parkingSpots;
  private int level;

  public ParkingFloor(int level) {
    this.level = level;
    parkingSpots = new HashMap<>();
  }

  public void addSpot(int spotId, ParkingSpot spot) {
    parkingSpots.put(spotId, spot);
  }

  public boolean isSpotAvailable(Vehicle vehicle) {
    for(Map.Entry<Integer, ParkingSpot> spot: parkingSpots.entrySet()) {
      if(!spot.getValue().isOccupied() && spot.getValue().canFitVehicle(vehicle)) return true;
    }
    return false;
  }

  public int getLevel() {
    return level;
  }

  public ParkingSpot getSpotById(int spotId) {
    if(parkingSpots.containsKey(spotId)) {
      return parkingSpots.get(spotId);
    }
    return null;
  }


  public List<ParkingSpot> getAllAvailableSpots(Vehicle vehicle) {
    List<ParkingSpot> freeSpots = new ArrayList<>();
    for(Map.Entry<Integer, ParkingSpot> spot: parkingSpots.entrySet()) {
      if(!spot.getValue().isOccupied() && spot.getValue().canFitVehicle(vehicle)) {
        freeSpots.add(spot.getValue());
      }
    }
    return freeSpots;
  }
}
