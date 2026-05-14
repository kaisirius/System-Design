package LLD.Problems.ElevatorSystem.state;

import LLD.Problems.ElevatorSystem.enums.Direction;
import LLD.Problems.ElevatorSystem.enums.RequestType;
import LLD.Problems.ElevatorSystem.models.Elevator;
import LLD.Problems.ElevatorSystem.models.Request;

public class MovingUpState implements IElevatorState {
  @Override
  public void move(Elevator elevator) {
    
    if(!elevator.hasRequests()) {
      elevator.setDirection(Direction.IDLE);
      elevator.setState(new StationaryState());
      return;
    }

    Request pickUpReq = new Request(elevator.getCurrentFloor(), RequestType.PICKUP_UP);
    Request destinationReq = new Request(elevator.getCurrentFloor(), RequestType.DESTINATION);

    if(elevator.containsRequest(pickUpReq) || elevator.containsRequest(destinationReq)) {
      System.out.println("Opening elevator at : " + elevator.getCurrentFloor());
      elevator.removeRequest(pickUpReq);
      elevator.removeRequest(destinationReq);

      if(!elevator.hasRequests()) {
        elevator.setDirection(Direction.IDLE);
        elevator.setState(new StationaryState());
        return;
      }
    }

    if(!elevator.hasRequestsAhead()) {
      elevator.setDirection(Direction.DOWN);
      elevator.setState(new MovingDownState());
      return;
    }

    elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);

  }
}
