package LLD.Problems.AirlineManagementSystem.models;

public class Aircraft {
  private String aircraftNo;
  private int totalSeats;
  private String model;

  public Aircraft(String no, int seats, String mdl) {
    aircraftNo = no;
    totalSeats = seats;
    model = mdl;
  }

  public String getAircraftNo() {
    return aircraftNo;
  }

  public String getModel() {
    return model;
  }

  public int getTotalSeats() {
    return totalSeats;
  }
}
