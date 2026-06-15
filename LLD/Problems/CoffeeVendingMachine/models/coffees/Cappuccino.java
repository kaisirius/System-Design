package LLD.Problems.CoffeeVendingMachine.models.coffees;

import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public class Cappuccino extends Coffee {
  public Cappuccino() {
    this.description = "Cappuccino";
  }

  @Override
  public void addCondiments() {
    System.out.println("- Adding steamed milk and foam.");
  }

  @Override
  public int getPrice() {
    return 250;
  }

  @Override
  public Map<Ingredient, Integer> getRecipe() {
    return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER, 30, Ingredient.MILK, 100);
  }
}
