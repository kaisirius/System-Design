public class Mocha extends ICoffee {
  public Mocha() {
    super("Mocha");
  }
  @Override 
  public String getName() {
    return name;
  }

  @Override 
  public int getPrice() {
    return basePrice + 20;
  }
}
