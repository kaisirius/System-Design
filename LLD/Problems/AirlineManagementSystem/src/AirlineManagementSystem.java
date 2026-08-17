import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.AirlineManagementSystem.enums.BookingStatus;
import LLD.Problems.AirlineManagementSystem.enums.SeatStatus;
import LLD.Problems.AirlineManagementSystem.manager.BookingManager;
import LLD.Problems.AirlineManagementSystem.models.Aircraft;
import LLD.Problems.AirlineManagementSystem.models.Booking;
import LLD.Problems.AirlineManagementSystem.models.Flight;
import LLD.Problems.AirlineManagementSystem.models.Passenger;
import LLD.Problems.AirlineManagementSystem.models.Seat;
import LLD.Problems.AirlineManagementSystem.service.SearchService;
import LLD.Problems.AirlineManagementSystem.strategy.IPaymentStrategy;

public class AirlineManagementSystem {

    private Map<String, Flight> flights;
    private Map<String, Aircraft> aircrafts;
    private Map<String, Passenger> passengers;

    private BookingManager bookingManager;
    private IPaymentStrategy paymentStrategy;
    private SearchService searchService;

    private static AirlineManagementSystem instance;

    private AirlineManagementSystem() {
        flights = new HashMap<>();
        aircrafts = new HashMap<>();
        passengers = new HashMap<>();

        bookingManager = new BookingManager();
        searchService = new SearchService();
    }

    public static AirlineManagementSystem getInstance() {
        if (instance == null) {
            instance = new AirlineManagementSystem();
        }

        return instance;
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getId(), flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.put(aircraft.getAircraftNo(), aircraft);
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public Booking bookFlight(String flightId,
                              String passengerId,
                              String seatNo,
                              double price) {

        Flight flight = flights.get(flightId);
        Passenger passenger = passengers.get(passengerId);

        if (flight == null) {
            throw new IllegalArgumentException(
                    "Flight not found: " + flightId
            );
        }

        if (passenger == null) {
            throw new IllegalArgumentException(
                    "Passenger not found: " + passengerId
            );
        }

        Seat seat = flight.getSeats().get(seatNo);

        if (seat == null) {
            throw new IllegalArgumentException(
                    "Seat not found: " + seatNo
            );
        }

        if (seat.getSeatStatus() == SeatStatus.RESERVED) {
            throw new IllegalStateException(
                    "Seat already reserved: " + seatNo
            );
        }

        // Reserve the seat on the flight
        flight.bookSeat(seatNo, passenger);

        // Add passenger to the flight
        flight.addPassenger(passenger);

        // Create booking
        return bookingManager.createBooking(
                flight,
                passenger,
                seat,
                price
        );
    }

    public List<Flight> searchFlight(String source,
                                     String destination,
                                     LocalDateTime dateTime) {

        return searchService.searchFlightsBeforeDate(
                source,
                destination,
                dateTime
        );
    }

    public void cancelBooking(String bookingId) {

        Booking booking = bookingManager.getBooking(bookingId);

        if (booking == null) {
            throw new IllegalArgumentException(
                    "Booking not found: " + bookingId
            );
        }

        Flight flight = booking.getFlight();
        Passenger passenger = booking.getBookedPassenger();
        Seat seat = booking.getBookedSeat();

        // Make seat available again
        seat.setSeatStatus(SeatStatus.AVAILABLE);

        // Remove passenger from flight
        flight.removePassenger(passenger);

        // Update booking status
        bookingManager.updateStatus(
                bookingId,
                BookingStatus.CANCELLED
        );
    }

    public void processPayment(double amount) {

        if (paymentStrategy == null) {
            throw new IllegalStateException(
                    "Payment strategy has not been set"
            );
        }

        paymentStrategy.processPayment(amount);
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Map<String, Flight> getFlights() {
        return flights;
    }

    public Map<String, Aircraft> getAircrafts() {
        return aircrafts;
    }

    public Map<String, Passenger> getPassengers() {
        return passengers;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public SearchService getSearchService() {
        return searchService;
    }
}