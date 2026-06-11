package LLD.Problems.TrafficSignalControlSystem.states.intersection;

import LLD.Problems.TrafficSignalControlSystem.enums.Direction;
import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.models.Intersection;

public class NorthSouthGreenState implements IntersectionState {
  
  @Override
  public void handle(Intersection context) throws InterruptedException {
      System.out.printf("\n--- INTERSECTION %d: Cycle Start -> North-South GREEN ---\n", context.getId());

      // Turn North and South green
      context.getLight(Direction.NORTH).transition();
      context.getLight(Direction.SOUTH).transition();

      // Wait for green light duration
      Thread.sleep(context.getGreenDuration());

      // Transition North and South to Yellow
      context.getLight(Direction.NORTH).transition();
      context.getLight(Direction.SOUTH).transition();

      // Wait for yellow light duration
      Thread.sleep(context.getYellowDuration());

      // Transition North and South to Red
      context.getLight(Direction.NORTH).transition();
      context.getLight(Direction.SOUTH).transition();

      // Change the intersection's state to let East-West go
      context.setState(new EastWestGreenState());
  }
}
