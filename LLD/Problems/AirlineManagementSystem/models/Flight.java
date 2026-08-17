package LLD.Problems.AirlineManagementSystem.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import LLD.Problems.AirlineManagementSystem.enums.FlightStatus;
import LLD.Problems.AirlineManagementSystem.enums.SeatStatus;
import LLD.Problems.AirlineManagementSystem.enums.SeatType;

public class Flight {
  private String id;
  private String source;
  private String destination;
  private LocalDateTime arrivalTime;
  private LocalDateTime departureTime;
  private FlightStatus status;
  private List<Passenger> passengers;
  private Aircraft aircraft;
  private List<Seat> availableSeats;
  private Map<String, Seat> seats;
  private Map<Seat, Passenger> listedPassenger;
  
  public Flight(String src, String dest, LocalDateTime arrival, LocalDateTime dep, FlightStatus stat, Aircraft aircraftDetails) {
    id = UUID.randomUUID().toString();
    source = src;
    destination = dest;
    arrivalTime = arrival;
    departureTime = dep;
    status = stat;
    passengers = new ArrayList<>();
    aircraft = aircraftDetails;
    availableSeats = new ArrayList<>();
    seats = new HashMap<>();
    for(Integer i = 1; i <= 30; i++) {
      for(char letter = 'A'; letter <= 'F'; letter++) {
        Seat seat = null;
        if(i <= 5) seat = new Seat(i.toString() + letter, SeatStatus.AVAILABLE, SeatType.FIRST_CLASS);
        else if(i <= 10) seat = new Seat(i.toString() + letter, SeatStatus.AVAILABLE, SeatType.BUSINESS);
        else seat = new Seat(i.toString() + letter, SeatStatus.AVAILABLE, SeatType.ECONOMY);

        availableSeats.add(seat);
        seats.put(seat.getSeatNo(), seat);
      }  
    }
    listedPassenger = new HashMap<>();
  }

  public String getId() {
    return id;
  }

  public String getSource() {
    return source;
  }

  public String getDestination() {
    return destination;
  }

  public LocalDateTime getArrivalTime() {
    return arrivalTime;
  }

  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  public FlightStatus getStatus() {
    return status;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public List<Seat> getAvailableSeats() {
    return availableSeats;
  }

  public Map<String, Seat> getSeats() {
    return seats;
  }

  public Map<Seat, Passenger> getListedPassenger() {
    return listedPassenger;
  }

  public Seat getSeatByNo(String no) {
    return seats.get(no);
  }

  public void setDepartureTime(LocalDateTime newTime) {
    departureTime = newTime;
  }

  public void setArrivalTime(LocalDateTime newTime) {
    arrivalTime = newTime;
  }

  public void setStatus(FlightStatus status) {
    this.status = status;
  }

  public void addPassenger(Passenger passenger) {
    passengers.add(passenger);
  }

  public void removePassenger(Passenger passenger) {
    passengers.remove(passenger);
  }

  public void addAvailableSeat(Seat seat) {
    availableSeats.add(seat);
  }

  public void removeAvailableSeat(Seat seat) {
    availableSeats.remove(seat);
  }

  public void addListedPassenger(Seat seat, Passenger passenger) {
    listedPassenger.put(seat, passenger);
  }

  public void removeListedPassenger(Seat seat) {
    listedPassenger.remove(seat);
  }

  public void bookSeat(String no, Passenger passenger) {
    Seat seat = seats.get(no);
    seat.setSeatStatus(SeatStatus.RESERVED);

    removeAvailableSeat(seat);
    passengers.add(passenger);
    listedPassenger.put(seat, passenger);
  }
}
