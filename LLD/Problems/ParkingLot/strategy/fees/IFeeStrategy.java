package LLD.Problems.ParkingLot.strategy.fees;

import LLD.Problems.ParkingLot.models.Ticket;

public interface IFeeStrategy {
  public double calculateFees(Ticket ticket); 
}
