package LLD.Problems.AirlineManagementSystem.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import LLD.Problems.AirlineManagementSystem.enums.BookingStatus;
import LLD.Problems.AirlineManagementSystem.models.Booking;
import LLD.Problems.AirlineManagementSystem.models.Flight;
import LLD.Problems.AirlineManagementSystem.models.Passenger;
import LLD.Problems.AirlineManagementSystem.models.Seat;

public class BookingManager {
  private Map<String, Booking> bookings;

  public BookingManager() {
    bookings = new HashMap<>();
  }

  public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {

    String bookingId = UUID.randomUUID().toString();

    Booking booking = new Booking(bookingId, BookingStatus.PENDING, flight, passenger, seat, price);

    bookings.put(bookingId, booking);

    return booking;
}

public void updateStatus(String bookingId, BookingStatus status) {

    Booking booking = bookings.get(bookingId);

    if (booking == null) {
        throw new IllegalArgumentException(
                "Booking not found: " + bookingId
        );
    }

    booking.setStatus(status);
}

public void deleteBooking(String bookingId) {

    Booking booking = bookings.remove(bookingId);

    if (booking == null) {
        throw new IllegalArgumentException(
                "Booking not found: " + bookingId
        );
    }
}

public Booking getBooking(String bookingId) {
    return bookings.get(bookingId);
}
}
