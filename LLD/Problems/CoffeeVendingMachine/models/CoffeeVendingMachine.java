package LLD.Problems.CoffeeVendingMachine.models;

import java.util.List;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.managers.FundManager;
import LLD.Problems.CoffeeVendingMachine.managers.InventoryManager;
import LLD.Problems.CoffeeVendingMachine.states.IMachineState;
import LLD.Problems.CoffeeVendingMachine.states.SelectingCoffeeState;

public class CoffeeVendingMachine {
  private static CoffeeVendingMachine instance;
  private InventoryManager inventoryManager;
  private FundManager fundManager;
  private IMachineState state;
  private Coffee selectedCoffee;
  private int moneyInserted;

  private CoffeeVendingMachine() {
    inventoryManager = new InventoryManager();
    fundManager = new FundManager();
    state = new SelectingCoffeeState();
    selectedCoffee = null;
    moneyInserted = 0;
  }

  public static CoffeeVendingMachine getInstance() {
    if(instance == null) {
      synchronized(CoffeeVendingMachine.class) {
        if(instance == null) {
          instance = new CoffeeVendingMachine();
        }
      }
    }
    return instance;
  }

  public void reset() {
    state = new SelectingCoffeeState();
    selectedCoffee = null;
    moneyInserted = 0;
  }

  public void selectCoffee(CoffeeType typeOfCoffee, List<ToppingType> toppings) {
    this.state.selectCoffee(instance, typeOfCoffee, toppings);
  }

  public void insertMoney(int noteValue, int amount) {
    this.state.insertMoney(instance, noteValue, amount);
  }

  public void makeCoffee() {
    this.state.makeCoffee(instance);
  }

  public void dispenseCoffee() {
    this.state.dispenseCoffee(instance);
  }


  public InventoryManager getInventoryManager() {
    return inventoryManager;
  }

  public FundManager getFundManager() {
    return fundManager;
  }

  public int getInsertedMoney() {
    return moneyInserted;
  }

  public Coffee getSelectedCoffee() {
    return selectedCoffee;
  }

  public void setState(IMachineState state) {
    this.state = state;
  }

  public void setSelectedCoffee(Coffee coffee) {
    selectedCoffee = coffee;
  }

  public void increaseMoneyInserted(int noteValue, int amount) {
    moneyInserted += (noteValue * amount);
  }
} 
