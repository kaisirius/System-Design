package LLD.Problems.HotelManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import LLD.Problems.HotelManagementSystem.models.Room;
import LLD.Problems.HotelManagementSystem.specification.Specification;

public class RoomService {
  private final List<Room> rooms = new ArrayList<>();

  public void addRoom(Room room) {
      rooms.add(room);
  }

  public List<Room> findRooms(Specification<Room> spec) {
      return rooms.stream()
              .filter(spec::isSatisfiedBy)
              .collect(Collectors.toList());
  }

  public Room findRoomByNumber(String roomNumber) {
      return rooms.stream()
              .filter(r -> r.getRoomNumber().equals(roomNumber))
              .findFirst()
              .orElse(null);
  }
}
