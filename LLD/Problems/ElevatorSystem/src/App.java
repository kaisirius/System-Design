import LLD.Problems.ElevatorSystem.enums.RequestType;

public class App {
    public static void main(String[] args) throws Exception {
        ElevatorSystem system =  new ElevatorSystem();

        system.reqElevator(2, RequestType.PICKUP_DOWN);
        system.reqElevator(4, RequestType.PICKUP_UP);

        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
        system.moveElevators();
    }
}
