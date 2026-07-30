package LLD.Problems.AuctionSystem.interfaces;

import LLD.Problems.AuctionSystem.models.Auction;
import LLD.Problems.AuctionSystem.models.Bid;

public interface IAuctionObserver {
  public void bidNotification(Auction auction, Bid bid);
  public boolean equals(Object o);
  public int hashCode();
}
