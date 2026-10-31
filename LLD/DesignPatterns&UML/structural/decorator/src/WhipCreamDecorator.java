public class WhipCreamDecorator extends CoffeeDecorator {
  public WhipCreamDecorator(ICoffee coffee) {
    super(coffee);
  }

  @Override 
  public String getName() {
    return super.getName() + " with whipped cream";
  }

  @Override 
  public int getPrice() {
    return super.getPrice() + 70;
  }
}
