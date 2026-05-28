package LLD.Problems.CarRentalSystem.manager;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.CarRentalSystem.enums.ReservationStatus;
import LLD.Problems.CarRentalSystem.helper.DateTimeHelper;
import LLD.Problems.CarRentalSystem.models.Car;
import LLD.Problems.CarRentalSystem.models.Customer;
import LLD.Problems.CarRentalSystem.models.DateTime;
import LLD.Problems.CarRentalSystem.models.Reservation;

public class ReservationManager {
  private Map<String, Reservation> reservations;

  public ReservationManager() {
    reservations = new HashMap<>();
  }

  public Reservation createReservation(Car car, Customer customer, DateTime startTime, DateTime endTime) {
    Reservation res = new Reservation("random1", car, customer, startTime, endTime);
    reservations.put(res.getId(), res);
    return res;
  }

  public void confirmReservation(String id) {
    if(reservations.containsKey(id)) {
      Reservation res = reservations.get(id);
      res.setStatus(ReservationStatus.CONFIRMED);
      reservations.replace(id, res);
    }
  }

  public void cancelReservation(String id) {
    if(reservations.containsKey(id)) {
      Reservation res = reservations.get(id);
      res.setStatus(ReservationStatus.CANCELLED);
      reservations.replace(id, res);
    }
  }

  public void startReservation(String id) {
    if(reservations.containsKey(id)) {
      Reservation res = reservations.get(id);
      res.setStatus(ReservationStatus.IN_PROGRESS);
      reservations.replace(id, res);
    }
  }

  public void completeReservation(String id) {
    if(reservations.containsKey(id)) {
      Reservation res = reservations.get(id);
      res.setStatus(ReservationStatus.COMPLETED);
      reservations.replace(id, res);
    }
  }

  public void removeReservation(String id) {
    reservations.remove(id);
  }

  public boolean isCarAvailable(Car car, DateTime startTime, DateTime endTime) {
    boolean flag = true;
    for(Map.Entry<String, Reservation> res: reservations.entrySet()) {
      if(res.getValue().getCar().getId() == car.getId()) {
        if(DateTimeHelper.isOverlappingTime(startTime, endTime, res.getValue().getStartTime(), res.getValue().getEndTime())) {
          flag = false;
        }
      }
    } 
    return flag;
  }
  
}
