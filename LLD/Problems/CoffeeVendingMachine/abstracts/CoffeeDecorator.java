package LLD.Problems.CoffeeVendingMachine.abstracts;

import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public abstract class CoffeeDecorator extends Coffee {
  protected Coffee wrapperCoffee;

  public CoffeeDecorator(Coffee wrapper) {
    wrapperCoffee = wrapper;
  }

  @Override
  public int getPrice() {
    return wrapperCoffee.getPrice();
  }

  @Override
  public Map<Ingredient, Integer> getRecipe() {
    return wrapperCoffee.getRecipe();
  }  

  @Override
  public void addCondiments() {
    wrapperCoffee.addCondiments();
  }

}
