package LLD.Problems.HotelManagementSystem.specification;

import LLD.Problems.HotelManagementSystem.enums.RoomType;
import LLD.Problems.HotelManagementSystem.models.Room;

public class RoomTypeSpecification extends AbstractSpecification<Room> {
  private final RoomType type;

  public RoomTypeSpecification(RoomType type) {
      this.type = type;
  }

  @Override
  public boolean isSatisfiedBy(Room item) {
      return item.getType() == type;
  }
}