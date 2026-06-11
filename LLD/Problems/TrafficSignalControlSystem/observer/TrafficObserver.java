package LLD.Problems.TrafficSignalControlSystem.observer;

import LLD.Problems.TrafficSignalControlSystem.enums.Direction;
import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;

public interface TrafficObserver {
  void update(int intersectionId, Direction direction, LightColor color);
}
