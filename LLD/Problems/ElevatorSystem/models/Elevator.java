package LLD.Problems.ElevatorSystem.models;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import LLD.Problems.ElevatorSystem.enums.Direction;
import LLD.Problems.ElevatorSystem.state.IElevatorState;
import LLD.Problems.ElevatorSystem.state.StationaryState;

public class Elevator {
  private int id;
  private int currentFloor;
  private Direction direction;
  private Set<Request> requests;
  private IElevatorState state;
  private static int autoIncrementorID = 1;

  public Elevator() {
    id = autoIncrementorID++;
    currentFloor = 0;
    direction = Direction.IDLE;
    requests = new HashSet<>();
    state = new StationaryState();
  }

  public void move() {
    state.move(this);
  }

  public void addRequest(Request req) {
    requests.add(req);
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public Direction getDirection() {
    return direction;
  }

  public int getId() {
    return id;
  }

  public void setCurrentFloor(int floor) {
    currentFloor = floor;
  }

  public void setDirection(Direction dir) {
    direction = dir;
  }

  public void setState(IElevatorState state) {
    this.state = state;
  }

  public void removeRequest(Request req) {
    requests.remove(req);
  }

  public boolean hasRequestsAhead() {
    for(Request req: requests) {
      if(direction == Direction.UP && req.getFloor() > currentFloor) return true;
      if(direction == Direction.DOWN && req.getFloor() < currentFloor) return true;
    }
    return false;
  }

  public boolean hasRequests() {
    return !(requests.isEmpty());
  }

  public boolean containsRequest(Request req) {
    // for(Request r: requests) {
    //   if(r.getFloor() == req.getFloor() && r.getType() == req.getType()) return true;
    // }
    // return false;

    return requests.contains(req);
  }

  public Request findNearestReqFloor() {
    int floorDistance = Integer.MAX_VALUE;
    Request r = null;
    for(Request req: requests) {
      if(Math.abs(req.getFloor() - currentFloor) < floorDistance) {
        floorDistance = Math.abs(req.getFloor() - currentFloor);
        r = req;
      } else if(Math.abs(req.getFloor() - currentFloor) == floorDistance) {
          if(req.getFloor() > currentFloor) {
            r = req;
          }
      }
    }
    return r;
  }
}
