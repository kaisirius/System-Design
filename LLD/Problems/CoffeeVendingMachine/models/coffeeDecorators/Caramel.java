package LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.abstracts.CoffeeDecorator;

public class Caramel extends CoffeeDecorator {
  public Caramel(Coffee wrapper) {
    super(wrapper);
  }

  @Override
  public void prepare() {
    wrapperCoffee.prepare();
    System.out.println("- Ading caramel syrup on top of it.");
  }

  @Override
  public int getPrice() {
    return super.getPrice() + 20;
  }

  @Override
  public String getDescription() {
    return wrapperCoffee.getDescription() + " x caramel.";
  }
}
