package LLD.Problems.CoffeeVendingMachine.states;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;

public interface IMachineState {
  public void selectCoffee(CoffeeVendingMachine machine, CoffeeType typeOfCoffee, List<ToppingType> toppings);
  public void insertMoney(CoffeeVendingMachine machine, int noteValue,int amount);
  public void makeCoffee(CoffeeVendingMachine machine);
  public void dispenseCoffee(CoffeeVendingMachine machine);
}
