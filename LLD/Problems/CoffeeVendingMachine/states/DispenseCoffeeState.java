package LLD.Problems.CoffeeVendingMachine.states;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;

public class DispenseCoffeeState implements IMachineState {
  @Override
  public void selectCoffee(CoffeeVendingMachine machine, CoffeeType typeOfCoffee, List<ToppingType> toppings) {
    System.out.println("Coffee already selected.");
  }

  @Override
  public void insertMoney(CoffeeVendingMachine machine, int noteValue, int amount) {
    System.out.println("Total amount already inserted");
  }

  @Override
  public void makeCoffee(CoffeeVendingMachine machine) {
    System.out.println("Coffee already ready.");
  }

  @Override
  public void dispenseCoffee(CoffeeVendingMachine machine) {
    System.out.println("Dispensing coffee: " + machine.getSelectedCoffee().getDescription());
    System.out.println("Price of coffee: " + machine.getSelectedCoffee().getPrice());
    machine.reset();
  }
}
