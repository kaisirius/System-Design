package LLD.Problems.HotelManagementSystem.specification;

import LLD.Problems.HotelManagementSystem.enums.RoomStyle;
import LLD.Problems.HotelManagementSystem.models.Room;

public class RoomStyleSpecification extends AbstractSpecification<Room> {
  private final RoomStyle style;

  public RoomStyleSpecification(RoomStyle style) {
      this.style = style;
  }

  @Override
  public boolean isSatisfiedBy(Room item) {
      return item.getStyle() == style;
  }
}
