package LLD.Problems.TrafficSignalControlSystem.states.intersection;

import LLD.Problems.TrafficSignalControlSystem.enums.Direction;
import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.models.Intersection;

public class EastWestGreenState implements IntersectionState {
  
  @Override
  public void handle(Intersection context) throws InterruptedException {
      System.out.printf("\n--- INTERSECTION %d: Cycle -> East-West GREEN ---\n", context.getId());

      // Turn East and West green
      context.getLight(Direction.EAST).transition();
      context.getLight(Direction.WEST).transition();


      // Wait for green light duration
      Thread.sleep(context.getGreenDuration());

      // Transition East and West to Yellow
      context.getLight(Direction.EAST).transition();
      context.getLight(Direction.WEST).transition();

      // Wait for yellow light duration
      Thread.sleep(context.getYellowDuration());

      // Transition East and West to Red
      context.getLight(Direction.EAST).transition();
      context.getLight(Direction.WEST).transition();

      // Change the intersection's state back to let North-South go
      context.setState(new NorthSouthGreenState());
  }
}
