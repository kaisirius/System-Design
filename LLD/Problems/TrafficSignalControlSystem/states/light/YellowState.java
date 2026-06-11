package LLD.Problems.TrafficSignalControlSystem.states.light;

import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.models.TrafficLight;

public class YellowState implements SignalState {
  
  @Override
  public void handle(TrafficLight context) {
      context.setColor(LightColor.YELLOW);
      // After being yellow, the next state is red.
      context.setNextState(new RedState());
  }
}
