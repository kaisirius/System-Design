import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.ParkingLot.models.ParkingFloor;
import LLD.Problems.ParkingLot.models.ParkingSpot;
import LLD.Problems.ParkingLot.models.Ticket;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;
import LLD.Problems.ParkingLot.strategy.fees.IFeeStrategy;
import LLD.Problems.ParkingLot.strategy.parking.IParkingStrategy;

public class ParkingLot {
  private static ParkingLot instance;
  private List<ParkingFloor> floors;
  private Map<Integer, Ticket> activeTickets;
  private IParkingStrategy parkingStrategy;
  private IFeeStrategy feeStrategy;

  private ParkingLot() {
    floors = new ArrayList<>();
    activeTickets = new HashMap<>();
  };

  public static ParkingLot getInstance() {
    if(instance == null) {
      synchronized(ParkingLot.class) {
        if(instance == null) {
          instance = new ParkingLot();
        }
      }
    }
    return instance;
  }

  public void addFloor(ParkingFloor floor) {
    floors.add(floor);
  }

  public boolean checkAvailableSpace(Vehicle vehicle) {
    for(ParkingFloor floor: floors) {
      if(floor.isSpotAvailable(vehicle)) return true;
    }
    return false;
  }

  public Ticket parkVehicle(Vehicle vehicle) {
    ParkingSpot spot = parkingStrategy.getParkingSpot(floors, vehicle);
    spot.parkVehicle(vehicle);

    Ticket ticket = new Ticket(vehicle, spot.getSpotId());
    activeTickets.put(ticket.getTicketId(), ticket);
    return ticket;
  }

  public void unparkVehicle(Ticket ticket) {
    if(!activeTickets.containsKey(ticket.getTicketId())) {
      System.out.println("Invalid ticket");
      return;
    }

    int spotIdUsed = ticket.getSpotId();
    ParkingSpot spotUsed = null;
    for(ParkingFloor floor : floors) {
      spotUsed = floor.getSpotById(spotIdUsed);

      if(spotUsed != null) break;
    }
    spotUsed.unparkVehicle();
    ticket.setExitTime();

    double fees = feeStrategy.calculateFees(ticket);
    System.out.println("Your fees is: " + fees);

    activeTickets.remove(ticket.getTicketId());
  }

  public void setParkingStrategy(IParkingStrategy parkingStrategy) {
    this.parkingStrategy = parkingStrategy;
  }

  public void setFeeStrategy(IFeeStrategy feeStrategy) {
    this.feeStrategy = feeStrategy;
  }
}
