public class ParkingLot {
  private static ParkingLot instance = null; // static member

  private ParkingLot() { // private constructor

  }

  public static ParkingLot getInstance() { // static get instance method (double check needed)
    if(instance == null) {
      synchronized(ParkingLot.class) {
        if(instance == null) {
          instance = new ParkingLot();
        }
      }
    } 
    return instance;
  }

  public void print() {
    System.out.println("parking LOTTTTTT");
  }
}
