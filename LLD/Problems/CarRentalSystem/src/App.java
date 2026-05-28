import java.util.List;

import LLD.Problems.CarRentalSystem.enums.CarType;
import LLD.Problems.CarRentalSystem.models.Car;
import LLD.Problems.CarRentalSystem.models.Customer;
import LLD.Problems.CarRentalSystem.models.DateTime;
import LLD.Problems.CarRentalSystem.models.RentalStore;
import LLD.Problems.CarRentalSystem.models.Reservation;
import LLD.Problems.CarRentalSystem.models.SEDANCar;
import LLD.Problems.CarRentalSystem.models.SUVCar;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("------------ Car Rental System ------------");

        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

        RentalStore store1 = new RentalStore("store1");
        RentalStore store2 = new RentalStore("store2");

        carRentalSystem.addStore(store1);
        carRentalSystem.addStore(store2);

        Customer customer1 = new Customer("customer1", "bhondu", "99XXXXXXXX", "MEFJO823");
        Customer customer2 = new Customer("customer2", "nakli_bhondu", "99XXXXXXXX", "MEFJO823");

        Car car1 = new SUVCar("car1", "Brezza-basic", "HR-A8-2098", CarType.SUV, 2015);
        Car car2 = new SEDANCar("car2", "skoda-slavia-basic", "UP-A8-2099", CarType.SEDAN, 2018);

        store1.addCar(car1);
        store2.addCar(car2);

        // customer1 comes
        List<RentalStore> stores = carRentalSystem.getStores();
        List<Car> cars = stores.get(0).getAllCars();

        Car selected = cars.get(0);
        DateTime startTime = new DateTime("28-05-2026", "15:00:000");
        DateTime endTime = new DateTime("28-05-2026", "17:00:000");
        if(carRentalSystem.checkAvailability(selected, startTime, endTime)) {
            Reservation res1 = carRentalSystem.makeReservation(selected, customer1, startTime, endTime);
            carRentalSystem.confirmReservation(res1.getId());
            System.out.println("Reservation for customer 1 done!");
        }

        // customer2 comes and tries to make same reservation
        if(carRentalSystem.checkAvailability(selected, startTime, endTime)) {
            Reservation res2 = carRentalSystem.makeReservation(selected, customer2, startTime, endTime);
            carRentalSystem.confirmReservation(res2.getId());
            System.out.println("Reservation for customer 2 done!");
        } else {
            System.out.println("Car unavailable");
        }
    }
}
