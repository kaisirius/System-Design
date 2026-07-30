package LLD.Problems.AuctionSystem.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import LLD.Problems.AuctionSystem.enums.AuctionStatus;
import LLD.Problems.AuctionSystem.interfaces.IAuctionObserver;
import LLD.Problems.AuctionSystem.mediator.AuctionMediator;

public class Auction {
  private int auctionId;
  private AuctionMediator auctionMediator;
  private List<Bid> bidsHistory;
  private double highestAmount;
  private Bid winningBid;
  private AuctionStatus status;
  private String name;
  private double startingAmount;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private static int autoIncrementor = 1;

  public Auction(String name) {
    auctionId = autoIncrementor++;
    auctionMediator = new AuctionMediator();
    bidsHistory = new ArrayList<>();
    highestAmount = 0;
    winningBid = null;
    status = AuctionStatus.ACTIVE;
    this.name = name;
    startingAmount = 0;
    startTime = LocalDateTime.now();
    endTime = null;
  }

  public int getId() {
    return auctionId;
  }

  public List<Bid> getBidsHistory() {
    return bidsHistory;
  }

  public double getHighestAmount() {
    return highestAmount;
  }

  public Bid getWinningBid() {
    return winningBid;
  }

  public AuctionStatus getAuctionStatus() {
    return status;
  }

  public String getName() {
    return name;
  }

  public double getStartingAmount() {
    return startingAmount;
  }

  public LocalDateTime getStartDateTime() {
    return startTime;
  }

  public LocalDateTime getEndDateTime() {
    return endTime;
  }

  public void addBidToHistory(Bid bid) {
    bidsHistory.add(bid);
  }

  public void setWinningBid(Bid bid) {
    winningBid = bid;
  }

  public void setStatus(AuctionStatus updatedStatus) {
    status = updatedStatus;
  }

  public boolean isActive() {
    return (status == AuctionStatus.ACTIVE);
  }

  public void endAuction() {
    if(winningBid == null) {
      System.out.println("Choose winning bid first.");
      return;
    }
    status = AuctionStatus.CLOSED;
    endTime = LocalDateTime.now();
  }

  public void chooseWinningBid(Bid bid) {
    if(winningBid == null)
      winningBid = bid;
    else 
      System.out.println("Winner already choosen");
  }

  public void addBidder(User bidder) {
    auctionMediator.addObserver(bidder);
  }

  public void removeBidder(User bidder) {
    auctionMediator.removeObserver(bidder);
  }

  public void handlePlacingBid(Bid bidPlaced) {
    bidsHistory.add(bidPlaced);
    if(bidPlaced.getBidAmount() > highestAmount) {
      highestAmount = bidPlaced.getBidAmount();
    }
    if(startingAmount == 0) {
      startingAmount = bidPlaced.getBidAmount();
    }
    auctionMediator.notifyBidders(this, bidPlaced);
  }

}