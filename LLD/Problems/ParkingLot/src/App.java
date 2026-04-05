import LLD.Problems.ParkingLot.enums.Size;
import LLD.Problems.ParkingLot.factory.VehicleFactory;
import LLD.Problems.ParkingLot.models.ParkingFloor;
import LLD.Problems.ParkingLot.models.ParkingSpot;
import LLD.Problems.ParkingLot.models.Ticket;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;
import LLD.Problems.ParkingLot.strategy.fees.FlatRateFeeStrategy;
import LLD.Problems.ParkingLot.strategy.parking.FirstFindParkingStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor_0 = new ParkingFloor(0);
        ParkingFloor floor_1 = new ParkingFloor(1);

        ParkingSpot s_0_0 = new ParkingSpot(Size.MEDIUM, "Car");
        ParkingSpot s_0_1 = new ParkingSpot(Size.SMALL, "Bike");
        ParkingSpot s_0_2 = new ParkingSpot(Size.LARGE, "Truck");
        ParkingSpot s_1_0 = new ParkingSpot(Size.MEDIUM, "Car");
        ParkingSpot s_1_1 = new ParkingSpot(Size.SMALL, "Bike");
        ParkingSpot s_1_2 = new ParkingSpot(Size.LARGE, "Truck");

        floor_0.addSpot(s_0_0.getSpotId(), s_0_0);
        floor_0.addSpot(s_0_1.getSpotId(), s_0_1);
        floor_0.addSpot(s_0_2.getSpotId(), s_0_2);
        floor_1.addSpot(s_1_0.getSpotId(), s_1_0);
        floor_1.addSpot(s_1_1.getSpotId(), s_1_1);
        floor_1.addSpot(s_1_2.getSpotId(), s_1_2);

        parkingLot.addFloor(floor_0);
        parkingLot.addFloor(floor_1);

        parkingLot.setParkingStrategy(new FirstFindParkingStrategy());
        parkingLot.setFeeStrategy(new FlatRateFeeStrategy());

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car_0 = vehicleFactory.createVehicle(Size.MEDIUM, "HR-AB-1111", "Car");
        Vehicle car_1 = vehicleFactory.createVehicle(Size.MEDIUM, "HR-AC-1112", "Car");
        Vehicle car_2 = vehicleFactory.createVehicle(Size.MEDIUM, "HR-AD-1113", "Car");

        Ticket tick_0 = null, tick_1 = null, tick_2 = null;

        if(parkingLot.checkAvailableSpace(car_0)) {
            tick_0 = parkingLot.parkVehicle(car_0);
            System.out.println("Ticket ID : " + tick_0.getTicketId());
            System.out.println("car0 parked on spotId : " + tick_0.getSpotId());
        } else {
            System.out.println("No space for vehicle 0");
        }

        if(parkingLot.checkAvailableSpace(car_1)) {
            tick_1 = parkingLot.parkVehicle(car_1);
            System.out.println("Ticket ID : " + tick_1.getTicketId());
            System.out.println("car1 parked on spotId : " + tick_1.getSpotId());
        } else {
            System.out.println("No space for vehicle 1");
        }

        if(parkingLot.checkAvailableSpace(car_2)) {
            tick_2 = parkingLot.parkVehicle(car_2);
        } else {
            System.out.println("No space for vehicle 2");
        }

        Thread.sleep(5000);

        parkingLot.unparkVehicle(tick_0);

        tick_2 = parkingLot.parkVehicle(car_2);
        System.out.println("Ticket ID : " + tick_2.getTicketId());
        System.out.println("car2 parked on spotId : " + tick_2.getSpotId());

        parkingLot.unparkVehicle(tick_0);

        // to check invalid arg exception
        // Vehicle car_3 = vehicleFactory.createVehicle(Size.MEDIUM, "HR-AB-1111", "Var");

    }
}
