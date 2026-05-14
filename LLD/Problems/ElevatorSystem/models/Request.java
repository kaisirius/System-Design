package LLD.Problems.ElevatorSystem.models;

import java.util.Objects;

import LLD.Problems.ElevatorSystem.enums.RequestType;

public class Request {
  private int floor;
  private RequestType type;

  public Request(int floor, RequestType type) {
    this.floor = floor;
    this.type = type;
  }

  public int getFloor() {
    return floor;
  }

  public RequestType getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o.getClass() != getClass()) return false;
    Request req = (Request) o;
    return (req.getFloor() == this.floor && req.getType() == this.type);
  }

  @Override // must override this hashcode else for different hash code java doesn't invoke equals method
  public int hashCode() {
    return Objects.hash(floor, type);
  }

}
