package LLD.Problems.AirlineManagementSystem.models;

import LLD.Problems.AirlineManagementSystem.enums.SeatStatus;
import LLD.Problems.AirlineManagementSystem.enums.SeatType;

public class Seat {
  private String seatNo;
  private SeatStatus status;
  private SeatType type;

  public Seat(String no, SeatStatus status, SeatType type) {
    seatNo = no;
    this.status = status;
    this.type = type;
  }

  public String getSeatNo() {
    return seatNo;
  }

  public SeatStatus getSeatStatus() {
    return status;
  }

  public SeatType getSeatType() {
    return type;
  }

  public void setSeatStatus(SeatStatus status) {
    this.status = status;
  }
}
