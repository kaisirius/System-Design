public class Bidder {
  private String name;
  private Mediator autionHouse;

  public Bidder(String name, Mediator auctionHouse) {
    this.name = name;
    this.autionHouse = auctionHouse;
  }

  public void placeBid(double amount) {
    autionHouse.handleBidPlacement(this, amount);
  }

  public void receiveUpdate(String msg) {
    System.out.println("Updates received to " + name + ": " + msg);
  } 

  public String getName() {
    return name;
  }
}
