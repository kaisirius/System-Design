package LLD.Problems.CarRentalSystem.models;

import LLD.Problems.CarRentalSystem.enums.ReservationStatus;
import LLD.Problems.CarRentalSystem.helper.DateTimeHelper;

public class Reservation {
  private String id;
  private Car car;
  private Customer customer;
  private DateTime startTime;
  private DateTime endTime;
  private ReservationStatus status;
  private double totalPrice;

  public Reservation(String id, Car car, Customer customer, DateTime startTime, DateTime endTime) {
    this.id = id; 
    this.car = car;
    this.customer = customer;
    this.startTime = startTime;
    this.endTime = endTime;
    status = ReservationStatus.PENDING;
    totalPrice = DateTimeHelper.calculateTimeInMinutes(startTime, endTime);
  }

  public String getId() {
    return id;
  }

  public Car getCar() {
    return car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public ReservationStatus getStatus() {
    return status;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public DateTime getStartTime() {
    return startTime;
  }

  public DateTime getEndTime() {
    return endTime;
  }

  public void setStatus(ReservationStatus updatedStatus) {
    status = updatedStatus;
  }


}
