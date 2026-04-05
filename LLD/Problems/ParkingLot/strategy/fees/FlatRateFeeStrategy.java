package LLD.Problems.ParkingLot.strategy.fees;

import java.time.Instant;

import LLD.Problems.ParkingLot.models.Ticket;

public class FlatRateFeeStrategy implements IFeeStrategy {
  @Override
  public double calculateFees(Ticket ticket) {

    long exitTime = ticket.getExitTime();
    long entryTime = ticket.getEntryTime();
    long durationInSecond = exitTime - entryTime;
    
    return durationInSecond * 10 * 5;
  }
}
