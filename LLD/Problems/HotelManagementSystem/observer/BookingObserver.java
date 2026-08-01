package LLD.Problems.HotelManagementSystem.observer;

import LLD.Problems.HotelManagementSystem.models.Booking;

public interface BookingObserver {
  void update(Booking booking);
}
