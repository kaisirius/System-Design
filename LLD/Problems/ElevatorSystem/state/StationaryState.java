package LLD.Problems.ElevatorSystem.state;

import LLD.Problems.ElevatorSystem.enums.Direction;
import LLD.Problems.ElevatorSystem.enums.RequestType;
import LLD.Problems.ElevatorSystem.models.Elevator;
import LLD.Problems.ElevatorSystem.models.Request;

public class StationaryState implements IElevatorState {
  @Override
  public void move(Elevator elevator) {

    if(!elevator.hasRequests()) {
      elevator.setDirection(Direction.IDLE);
      elevator.setState(new StationaryState());
      return;
    }
    Request req = elevator.findNearestReqFloor();

    if(req.getFloor() > elevator.getCurrentFloor()) {
      elevator.setDirection(Direction.UP);
      elevator.setState(new MovingUpState());
    } else if(req.getFloor() < elevator.getCurrentFloor()) {
      elevator.setDirection(Direction.DOWN);
      elevator.setState(new MovingDownState());
    } else {
      elevator.setDirection(req.getType() == RequestType.PICKUP_UP ? Direction.UP : Direction.DOWN);
      elevator.setState(req.getType() == RequestType.PICKUP_UP ? new MovingUpState() : new MovingDownState());
    }

  }
}
