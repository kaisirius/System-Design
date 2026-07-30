package LLD.Problems.AuctionSystem.models;

import java.time.LocalDateTime;

public class Bid {
  private User bidder;
  private double bidAmount;
  private LocalDateTime timestamp;

  public Bid(User bidder, double bidAmount) {
    this.bidder = bidder;
    this.bidAmount = bidAmount;
    timestamp = LocalDateTime.now();
  }

  public User getBidder() {
    return bidder;
  }

  public double getBidAmount() {
    return bidAmount;
  }
}
