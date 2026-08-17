package LLD.Problems.AirlineManagementSystem.models;

import LLD.Problems.AirlineManagementSystem.enums.BookingStatus;

public class Booking {
  private String id;
  private BookingStatus status;
  private Flight flight;
  private Passenger bookedPassenger;
  private Seat bookedSeat;
  private double price;

  public Booking(String id, BookingStatus status, Flight flight, Passenger bookedPassenger, Seat bookedSeat, double price) {
    this.id = id;
    this.status = status;
    this.flight = flight;
    this.bookedPassenger = bookedPassenger;
    this.bookedSeat = bookedSeat;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public Passenger getBookedPassenger() {
    return bookedPassenger;
  }

  public void setBookedPassenger(Passenger bookedPassenger) {
    this.bookedPassenger = bookedPassenger;
  }

  public Seat getBookedSeat() {
    return bookedSeat;
  }

  public void setBookedSeat(Seat bookedSeat) {
    this.bookedSeat = bookedSeat;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
