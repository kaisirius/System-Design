public interface Mediator {
  public void registerBidder(Bidder bidder);
  public void handleBidPlacement(Bidder bidder, double amount);
}