package LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.abstracts.CoffeeDecorator;

public class Whip extends CoffeeDecorator {
  public Whip(Coffee wrapper) {
    super(wrapper);
  }

  @Override
  public void prepare() {
    wrapperCoffee.prepare();
    System.out.println(", Ading whipped cream on top of it.");
  }

  @Override
  public int getPrice() {
    return super.getPrice() + 30;
  }

  @Override
  public String getDescription() {
    return wrapperCoffee.getDescription() + " x whipped cream.";
  }
}
