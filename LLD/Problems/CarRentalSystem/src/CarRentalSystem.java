import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.CarRentalSystem.manager.ReservationManager;
import LLD.Problems.CarRentalSystem.models.Car;
import LLD.Problems.CarRentalSystem.models.Customer;
import LLD.Problems.CarRentalSystem.models.DateTime;
import LLD.Problems.CarRentalSystem.models.PaymentProcessor;
import LLD.Problems.CarRentalSystem.models.RentalStore;
import LLD.Problems.CarRentalSystem.models.Reservation;
import LLD.Problems.CarRentalSystem.strategy.PaymentStrategy;

public class CarRentalSystem {
  public static CarRentalSystem instance;
  private Map<String, RentalStore> stores;
  private ReservationManager reservationManager;
  private PaymentProcessor paymentProcessor;

  private CarRentalSystem() {
    stores = new HashMap<>();
    reservationManager = new ReservationManager();
    paymentProcessor = new PaymentProcessor();
  }

  public static CarRentalSystem getInstance() {
    if(instance == null) {
      synchronized(CarRentalSystem.class) {
        if(instance == null) {
          instance = new CarRentalSystem();
        }
      }
    }
    return instance;
  }

  public void addStore(RentalStore store) {
    stores.put(store.getId(), store);
  }

  public void removeStore(String id) {
    stores.remove(id);
  }

  public Reservation makeReservation(Car car, Customer customer, DateTime startTime, DateTime endTime) {
    return reservationManager.createReservation(car, customer, startTime, endTime);
  }

  public void confirmReservation(String id) {
    reservationManager.confirmReservation(id);
  }

  public void cancelReservation(String id) {
    reservationManager.cancelReservation(id);
  }

  public void startReservation(String id) {
    reservationManager.startReservation(id);
  }

  public void completeReservation(String id) {
    reservationManager.completeReservation(id);
  }

  public void removeReservation(String id) {
    reservationManager.removeReservation(id);
  }

  public boolean checkAvailability(Car car, DateTime startTime, DateTime endTime) {
    return reservationManager.isCarAvailable(car, startTime, endTime);
  }

  public void initPayment(double amount, PaymentStrategy stratgey) {
    paymentProcessor.processPayment(amount, stratgey);
  }

  public List<RentalStore> getStores() {
    List<RentalStore> listOfStores = new ArrayList<>();
    for(Map.Entry<String, RentalStore> store: stores.entrySet()) {
      listOfStores.add(store.getValue());
    }
    return listOfStores;
  }
}
