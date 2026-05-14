package LLD.Problems.ElevatorSystem.strategy;

import java.util.Map;

import LLD.Problems.ElevatorSystem.models.Elevator;
import LLD.Problems.ElevatorSystem.models.Request;

public interface IReqElevatorStrategy {
  public Elevator reqElevator(Request req, Map<Integer, Elevator> elevators);
}
