package LLD.Problems.CoffeeVendingMachine.states;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.factory.CoffeeFactory;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;
import LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators.Caramel;
import LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators.Whip;

public class SelectingCoffeeState implements IMachineState {
  @Override
  public void selectCoffee(CoffeeVendingMachine machine, CoffeeType typeOfCoffee, List<ToppingType> toppings) {
    Coffee selectedCoffee = CoffeeFactory.createCofee(typeOfCoffee);

    for(ToppingType toppingType: toppings) {
      switch (toppingType) {
        case ToppingType.CARAMEL:
          selectedCoffee = new Caramel(selectedCoffee);
          break;
      
        case ToppingType.WHIP_CREAM:
          selectedCoffee = new Whip(selectedCoffee);  
        default:
          break;
      }
    }

    machine.setSelectedCoffee(selectedCoffee);
    // check from inventory manager if we have required amount of ingredients else throw error
    machine.setState(new InsertMoneyState());
  }

  @Override
  public void insertMoney(CoffeeVendingMachine machine, int noteValue,int amount) {
    System.out.println("Please select a coffee before inserting money.");
  }

  @Override
  public void makeCoffee(CoffeeVendingMachine machine) {
    System.out.println("Please select a coffee before initiating making of coffee.");
  }

  @Override
  public void dispenseCoffee(CoffeeVendingMachine machine) {
    System.out.println("Please select a coffee before dispensing it.");
  }
}
