package LLD.Problems.CoffeeVendingMachine.states;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;

public class ReadyToMakeCoffeeState implements IMachineState {
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
    System.out.println("Making cofee");
    machine.getSelectedCoffee().prepare();
    try {
      // do inventory manager operations
      Thread.sleep(5000);
      machine.setState(new DispenseCoffeeState());
    } catch(InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void dispenseCoffee(CoffeeVendingMachine machine) {
    System.out.println("Please insert money before dispensing it.");
  }
}
