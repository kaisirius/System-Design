package LLD.Problems.ParkingLot.factory;

import java.security.InvalidAlgorithmParameterException;

import LLD.Problems.ParkingLot.enums.Size;
import LLD.Problems.ParkingLot.models.vehicle.Bike;
import LLD.Problems.ParkingLot.models.vehicle.Car;
import LLD.Problems.ParkingLot.models.vehicle.Truck;
import LLD.Problems.ParkingLot.models.vehicle.Vehicle;

public class VehicleFactory {
  public Vehicle createVehicle(Size size,String licenseNo, String type) throws InvalidAlgorithmParameterException {
    if(type == "Car") {
      return new Car(size, licenseNo, type);
    } else if(type == "Truck") {
      return new Truck(size, licenseNo, type);
    } else if(type == "Bike") {
      return new Bike(size, licenseNo, type);
    } else {
      throw new InvalidAlgorithmParameterException();
    }
    
  }
}
