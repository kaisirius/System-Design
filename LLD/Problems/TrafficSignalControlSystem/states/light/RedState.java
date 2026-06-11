package LLD.Problems.TrafficSignalControlSystem.states.light;

import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.models.TrafficLight;

public class RedState implements SignalState {
  
  @Override
  public void handle(TrafficLight context) {
      context.setColor(LightColor.RED);
      // Red is a stable state, it transitions to green only when the intersection controller commands it.
      // So, the next state is self.
      context.setNextState(new GreenState());
  }
}
