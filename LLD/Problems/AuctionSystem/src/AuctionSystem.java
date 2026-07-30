import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.AuctionSystem.models.Auction;
import LLD.Problems.AuctionSystem.models.Bid;
import LLD.Problems.AuctionSystem.models.User;

public class AuctionSystem {
  private Map<Integer, User> users;
  private Map<Integer, Auction> auctions;
  private static AuctionSystem instance;
  
  private AuctionSystem() {
    users = new HashMap<>();
    auctions = new HashMap<>();
  }

  public static AuctionSystem getInstance() {
    if(instance == null) {
      synchronized(AuctionSystem.class) {
        if(instance == null) {
          instance = new AuctionSystem();
        }
      }
    }
    return instance;
  }

  public Auction getAuctionById(int id) {
    return auctions.get(id);
  }

  public User getUserById(int id) {
    return users.get(id);
  }

  public int createAuction(String name) {
    Auction auction = new Auction(name);
    auctions.put(auction.getId(), auction);

    return auction.getId();
  }

  public int createUser(String name) {
    User user = new User(name);
    users.put(user.getId(), user);

    return user.getId();
  }

  public void endAuction(int id) {
    if(auctions.containsKey(id)) {
      auctions.get(id).endAuction();
    }
  }

  public List<Auction> getActiveAuctions() {
    List<Auction> activeAuctions = new ArrayList<>();
    for(Map.Entry<Integer, Auction> auction: auctions.entrySet()) {
      if(auction.getValue().isActive()) {
        activeAuctions.add(auction.getValue());
      }
    }
    
    return activeAuctions;
  }

  public void placeBid(int userId, int auctionId, double bidAmount) {
    User bidder = users.get(userId);
    Bid bid = new Bid(bidder, bidAmount);

    auctions.get(auctionId).handlePlacingBid(bid);
  } 

  public void addBidder(int auctionId, int userId) {
    auctions.get(auctionId).addBidder(users.get(userId));
  }

  public void removeBidder(int auctionId, int userId) {
    auctions.get(auctionId).removeBidder(users.get(userId));
  }

}
