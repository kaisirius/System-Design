package LLD.Problems.CarRentalSystem.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalStore {
  private String id;
  private Map<String, Car> cars;

  public RentalStore(String id) {
    this.id = id;
    cars = new HashMap<>();

    // for(Map.Entry<String, Car> items: cars.entrySet()) {
    //   System.out.println(items.getKey() + " " + items.getValue()) ;
    // }
  }

  public String getId() {
    return id;
  }

  public void addCar(Car car) {
    cars.put(car.getId(), car);
  }

  public void removeCar(String id) {
    cars.remove(id);
  }

  public List<Car> getAllCars() {
    List<Car> listOfCars = new ArrayList<>();
    for(Map.Entry<String, Car> car: cars.entrySet()) {
      listOfCars.add(car.getValue());
    }
    return listOfCars;
  }
}
