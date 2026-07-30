package LLD.Problems.AuctionSystem.mediator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import LLD.Problems.AuctionSystem.interfaces.IAuctionObserver;
import LLD.Problems.AuctionSystem.models.Auction;
import LLD.Problems.AuctionSystem.models.Bid;
import LLD.Problems.AuctionSystem.models.User;

public class AuctionMediator {
  private Set<User> bidders;

  public AuctionMediator() {
    bidders = new HashSet<>();
  }

  public void addObserver(User observer) {
    bidders.add(observer);
  }

  public void removeObserver(User observer) {
    bidders.remove(observer);
  }

  public void notifyBidders(Auction auction, Bid bid) {
    for(User observer: bidders) {
      if(bid.getBidder() != observer)
      observer.bidNotification(auction, bid);
    }
  }
}
