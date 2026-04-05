package LLD.Problems.ParkingLot.models;

import java.time.Instant;

import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public class Ticket {
  private int ticketId;
  private static int idIncrementor = 1;
  private Vehicle vehicle;
  private int spotId;
  private long entryTime;
  private long exitTime;

  public Ticket(Vehicle vehicle, int spotId) {
    ticketId = idIncrementor++;
    this.vehicle = vehicle;
    this.spotId = spotId;
    this.entryTime = Instant.now().getEpochSecond();
  }

  public void setExitTime() {
    this.exitTime = Instant.now().getEpochSecond();
  }

  public int getTicketId() {
    return this.ticketId;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public int getSpotId() {
    return this.spotId;
  }

  public long getEntryTime() {
    return this.entryTime;
  }

  public long getExitTime() {
    return this.exitTime;
  }
  public void displayTicket() {
    // TODO
  }
}
