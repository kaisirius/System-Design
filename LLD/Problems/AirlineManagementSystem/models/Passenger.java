package LLD.Problems.AirlineManagementSystem.models;

import java.util.UUID;

public class Passenger {
  private String id;
  private String name;
  private String email;

  public Passenger(String name, String email) {
    this.id = UUID.randomUUID().toString();
    this.email = email;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
