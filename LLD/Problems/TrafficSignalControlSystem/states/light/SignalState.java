package LLD.Problems.TrafficSignalControlSystem.states.light;

import LLD.Problems.TrafficSignalControlSystem.models.TrafficLight;

public interface SignalState {
  void handle(TrafficLight context);
}
