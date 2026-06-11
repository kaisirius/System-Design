package LLD.Problems.TrafficSignalControlSystem.models;
import java.util.ArrayList;
import java.util.List;

import LLD.Problems.TrafficSignalControlSystem.enums.Direction;
import LLD.Problems.TrafficSignalControlSystem.enums.LightColor;
import LLD.Problems.TrafficSignalControlSystem.observer.TrafficObserver;
import LLD.Problems.TrafficSignalControlSystem.states.light.GreenState;
import LLD.Problems.TrafficSignalControlSystem.states.light.RedState;
import LLD.Problems.TrafficSignalControlSystem.states.light.SignalState;

public class TrafficLight {
  private final Direction direction;
  private LightColor currentColor;
  private SignalState currentState;
  private SignalState nextState; // The state to transition to after a timer elapses
  private final List<TrafficObserver> observers = new ArrayList<>();
  private final int intersectionId;

  public TrafficLight(int intersectionId, Direction direction) {
      this.intersectionId = intersectionId;
      this.direction = direction;
      this.currentState = new RedState(); // Default state is Red
      this.currentState.handle(this);
  }

  // This is called by the IntersectionController to initiate a G-Y-R cycle
  public void startGreen() {
      
      this.currentState = new GreenState();
      this.currentState.handle(this);
  }

  // This is called by the IntersectionController to transition from G->Y or Y->R
  public void transition() {
      this.currentState = this.nextState;
      this.currentState.handle(this);
  }

  public void setColor(LightColor color) {
      if (this.currentColor != color) {
          this.currentColor = color;
          notifyObservers();
      }
  }

  public void setNextState(SignalState state) {
      this.nextState = state;
  }

  public LightColor getCurrentColor() {
      return currentColor;
  }

  public Direction getDirection() {
      return direction;
  }

  // Observer pattern methods
  public void addObserver(TrafficObserver observer) {
      observers.add(observer);
  }

  public void removeObserver(TrafficObserver observer) {
      observers.remove(observer);
  }

  private void notifyObservers() {
      for (TrafficObserver observer : observers) {
          observer.update(intersectionId, direction, currentColor);
      }
  }
}
