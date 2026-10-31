public class CaramelDecorator extends CoffeeDecorator {
  public CaramelDecorator(ICoffee coffee) {
    super(coffee);
  }

  @Override 
  public String getName() {
    return super.getName() + " with caramel";
  }

  @Override 
  public int getPrice() {
    return super.getPrice() + 50;
  }
}
