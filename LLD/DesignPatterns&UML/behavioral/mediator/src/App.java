public class App {
    public static void main(String[] args) throws Exception {
        Mediator auctionHouse = new AuctionMediator();
        Bidder bidder1 = new Bidder("BIDDER1", auctionHouse);
        Bidder bidder2 = new Bidder("BIDDER2", auctionHouse);
        Bidder bidder3 = new Bidder("BIDDER3", auctionHouse);

        auctionHouse.registerBidder(bidder1);
        auctionHouse.registerBidder(bidder2);
        auctionHouse.registerBidder(bidder3);

        bidder2.placeBid(20);
        bidder3.placeBid(30);
        bidder1.placeBid(50);
    }
}
