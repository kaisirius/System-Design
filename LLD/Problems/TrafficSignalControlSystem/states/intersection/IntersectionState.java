package LLD.Problems.TrafficSignalControlSystem.states.intersection;

import LLD.Problems.TrafficSignalControlSystem.models.Intersection;

public interface IntersectionState {
  void handle(Intersection context) throws InterruptedException;
}
