package LLD.Problems.CoffeeVendingMachine.factory;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.models.coffees.Cappuccino;
import LLD.Problems.CoffeeVendingMachine.models.coffees.Espresso;
import LLD.Problems.CoffeeVendingMachine.models.coffees.Latte;

public class CoffeeFactory {
  public static Coffee createCofee(CoffeeType type) {
    switch (type) {
      case CoffeeType.ESPRESSO: 
        return new Espresso();
        
      case CoffeeType.CAPPUCCINO:
        return new Cappuccino();

      case CoffeeType.LATTE:
        return new Latte();

      default:
        return null;
    }
  }
}
