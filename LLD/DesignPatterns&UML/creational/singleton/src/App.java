public class App {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingLot parkingLot2 = ParkingLot.getInstance();

        parkingLot.print();
        parkingLot2.print();

        if(parkingLot.equals(parkingLot2)) System.out.println("Singleton");
        else System.out.println("Not Singleton");
    }
}
