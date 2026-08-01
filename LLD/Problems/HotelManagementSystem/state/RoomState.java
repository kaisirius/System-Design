package LLD.Problems.HotelManagementSystem.state;

import LLD.Problems.HotelManagementSystem.models.Room;

public interface RoomState {
  void book(Room room);
  void checkIn(Room room);
  void checkOut(Room room);
  void markForMaintenance(Room room);
}
