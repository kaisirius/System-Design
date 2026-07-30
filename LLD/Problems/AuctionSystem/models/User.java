package LLD.Problems.AuctionSystem.models;

import java.util.Objects;

import LLD.Problems.AuctionSystem.interfaces.IAuctionObserver;

public class User implements IAuctionObserver {
  private int userId;
  private String name;
  private static int autoIncrementor = 1;

  public User(String name) {
    this.name = name;
    userId = autoIncrementor++;
  }

  public int getId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if(o == this) return true;
    if(o.getClass() != getClass()) return false;
    User user = (User)o;
    return (this.userId == user.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name);
  }

  public void bidNotification(Auction auction, Bid bid) {
    System.out.println(name + " got notified about : " + auction.getId() + " with a bid of " + bid.getBidAmount() + " by " + bid.getBidder().getName());
  }
}
