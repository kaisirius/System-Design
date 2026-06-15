package LLD.Problems.CoffeeVendingMachine.models.coffees;

import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public class Latte extends Coffee {

  public Latte() {
    this.description = "Latte";
  }

  @Override
  public void addCondiments() {
    System.out.println("- Adding steamed milk.");
  }

  @Override
  public int getPrice() {
    return 220;
  }

  @Override
  public Map<Ingredient, Integer> getRecipe() {
    return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER, 30, Ingredient.MILK, 150);
  }
}
