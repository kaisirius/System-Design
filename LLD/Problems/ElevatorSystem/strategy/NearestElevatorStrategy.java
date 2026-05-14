package LLD.Problems.ElevatorSystem.strategy;

import java.util.Map;

import LLD.Problems.ElevatorSystem.models.Elevator;
import LLD.Problems.ElevatorSystem.models.Request;

public class NearestElevatorStrategy implements IReqElevatorStrategy {
  @Override
  public Elevator reqElevator(Request req, Map<Integer, Elevator> elevators) {
   // to do  
   // can return elevator id 
   return elevators.get(1);
  }
}
