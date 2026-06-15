package LLD.Problems.CoffeeVendingMachine.models.coffees;

import java.util.Map;

import LLD.Problems.CoffeeVendingMachine.abstracts.Coffee;
import LLD.Problems.CoffeeVendingMachine.enums.Ingredient;

public class Espresso extends Coffee {
    public Espresso() {
      this.description = "Espresso";
    }

    @Override
    public void addCondiments() { /* No extra condiments for espresso */ }

    @Override
    public int getPrice() {
      return 150;
    }

    @Override
    public Map<Ingredient, Integer> getRecipe() {
        return Map.of(Ingredient.COFFEE_BEANS, 7, Ingredient.WATER, 30);
    }
}
