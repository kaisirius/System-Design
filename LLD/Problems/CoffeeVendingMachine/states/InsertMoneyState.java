package LLD.Problems.CoffeeVendingMachine.states;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.factory.CoffeeFactory;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;
import LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators.Caramel;
import LLD.Problems.CoffeeVendingMachine.models.coffeeDecorators.Whip;

public class InsertMoneyState implements IMachineState {
  @Override
  public void selectCoffee(CoffeeVendingMachine machine, CoffeeType typeOfCoffee, List<ToppingType> toppings) {
    System.out.println("Coffee already selected.");
  }

  @Override
  public void insertMoney(CoffeeVendingMachine machine, int noteValue, int amount) {
    machine.increaseMoneyInserted(noteValue, amount);
    machine.getFundManager().addMoney(noteValue, amount);
    if(machine.getInsertedMoney() >= machine.getSelectedCoffee().getPrice()) {
      machine.setState(new ReadyToMakeCoffeeState());
      return;
    }
    System.out.println("Add remaining money");
  }

  @Override
  public void makeCoffee(CoffeeVendingMachine machine) {
    System.out.println("Please insert money before we start making it.");
  }

  @Override
  public void dispenseCoffee(CoffeeVendingMachine machine) {
    System.out.println("Please insert money before dispensing it.");
  }
}
