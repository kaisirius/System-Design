package LLD.Problems.HotelManagementSystem.specification;

import LLD.Problems.HotelManagementSystem.models.Room;
import LLD.Problems.HotelManagementSystem.state.AvailableState;

public class RoomAvailableSpecification extends AbstractSpecification<Room> {
    @Override
    public boolean isSatisfiedBy(Room item) {
        return item.getState() instanceof AvailableState;
    }
}
