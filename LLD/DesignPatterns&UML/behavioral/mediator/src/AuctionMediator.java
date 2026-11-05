import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
  private List<Bidder> bidders;

  public AuctionMediator() {
    bidders = new ArrayList<>();
  } 

  @Override 
  public void registerBidder(Bidder bidder) {
    bidders.add(bidder);
  }

  @Override 
  public void handleBidPlacement(Bidder bidder, double amount) {
    for(Bidder b: bidders) {
      if(b != bidder) {
        b.receiveUpdate("New bid from Bidder: " + bidder.getName() + " of amount: " + amount);
      }
    }
  }
}
