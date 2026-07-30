import LLD.Problems.AuctionSystem.models.Auction;

public class App {
    public static void main(String[] args) throws Exception {
        AuctionSystem auctionSystem = AuctionSystem.getInstance();

        int userId1 = auctionSystem.createUser("gurt-1");
        int userId2 = auctionSystem.createUser("gurt-2");
        int userId3 = auctionSystem.createUser("gurt-3");

        int auctionId1 = auctionSystem.createAuction("FIFA-2026");
        int auctionId2 = auctionSystem.createAuction("IPL-2026");

        auctionSystem.addBidder(auctionId1, userId1);
        auctionSystem.addBidder(auctionId1, userId2);

        auctionSystem.addBidder(auctionId2, userId3);
        auctionSystem.addBidder(auctionId2, userId1);

        auctionSystem.placeBid(userId1, auctionId1, 500);
        auctionSystem.placeBid(userId2, auctionId1, 550);
        auctionSystem.placeBid(userId1, auctionId1, 600);

        Auction auction1 = auctionSystem.getAuctionById(auctionId1);
        auction1.chooseWinningBid(auction1.getBidsHistory().get(auction1.getBidsHistory().size() - 1));
        // auction1.endAuction();

        auctionSystem.placeBid(userId3, auctionId2, 100);
        auctionSystem.placeBid(userId1, auctionId2, 200);

        Auction auction2 = auctionSystem.getAuctionById(auctionId2);
        auction2.chooseWinningBid(auction2.getBidsHistory().get(auction2.getBidsHistory().size() - 1));
        auction2.endAuction();

       auctionSystem.removeBidder(auctionId1, userId1);

       auctionSystem.placeBid(userId2, auctionId1, 1);
    }
}
