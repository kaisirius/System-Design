public abstract class CoffeeDecorator extends ICoffee {
  protected ICoffee wrappee;

  public CoffeeDecorator(ICoffee coffee) {
    wrappee = coffee;
    super(coffee.getName());
  }

  @Override 
  public String getName() {
    return wrappee.getName();
  }

  @Override 
  public int getPrice() {
    return wrappee.getPrice();
  }
}
