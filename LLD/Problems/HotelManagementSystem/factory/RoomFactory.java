package LLD.Problems.HotelManagementSystem.factory;

import LLD.Problems.HotelManagementSystem.enums.RoomStyle;
import LLD.Problems.HotelManagementSystem.enums.RoomType;
import LLD.Problems.HotelManagementSystem.models.Room;

public class RoomFactory {
   public static Room createRoom(String roomNumber, String type, String style, double price) {
      RoomType roomType = RoomType.valueOf(type.toUpperCase());
      RoomStyle roomStyle = RoomStyle.valueOf(style.toUpperCase());
      return new Room(roomNumber, roomType, roomStyle, price);
    }
}
