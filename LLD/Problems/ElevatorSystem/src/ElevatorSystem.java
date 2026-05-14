import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import LLD.Problems.ElevatorSystem.enums.Direction;
import LLD.Problems.ElevatorSystem.enums.RequestType;
import LLD.Problems.ElevatorSystem.models.Elevator;
import LLD.Problems.ElevatorSystem.models.Request;
import LLD.Problems.ElevatorSystem.strategy.IReqElevatorStrategy;
import LLD.Problems.ElevatorSystem.strategy.NearestElevatorStrategy;

public class ElevatorSystem {
  private Map<Integer, Elevator> elevators;
  private IReqElevatorStrategy strategy;
  
  public ElevatorSystem() {
    Elevator elevator1 = new Elevator();
    Elevator elevator2 = new Elevator();
    Elevator elevator3 = new Elevator();
    
    elevators = new HashMap<>();

    elevators.put(elevator1.getId(), elevator1);
    elevators.put(elevator2.getId(), elevator2);
    elevators.put(elevator3.getId(), elevator3);

    strategy = new NearestElevatorStrategy();
  }

  public void moveElevators() {
    for(Map.Entry<Integer, Elevator> e: elevators.entrySet()) {
      e.getValue().move();
    }
  }

  public void reqElevator(int floor, RequestType type) {
    Request req = new Request(floor, type);
    Elevator bestElevator = strategy.reqElevator(req, elevators);

    bestElevator.addRequest(req);
  }
}
