public class Latte extends ICoffee {
  public Latte() {
    super("Latte");
  }
  @Override 
  public String getName() {
    return name;
  }

  @Override 
  public int getPrice() {
    return basePrice + 30;
  }
}
