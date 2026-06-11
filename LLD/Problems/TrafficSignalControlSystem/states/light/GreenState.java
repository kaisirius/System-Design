package LLD.Problems.TrafficSignalControlSystem.states.light;

import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.models.TrafficLight;

public class GreenState implements SignalState {
  
  @Override
  public void handle(TrafficLight context) {
      context.setColor(LightColor.GREEN);
      // After being green, the next state is yellow.
      context.setNextState(new YellowState());
  }
}
