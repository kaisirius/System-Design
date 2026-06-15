import java.util.List;

import LLD.Problems.CoffeeVendingMachine.enums.CoffeeType;
import LLD.Problems.CoffeeVendingMachine.enums.ToppingType;
import LLD.Problems.CoffeeVendingMachine.models.CoffeeVendingMachine;

public class App {
    public static void main(String[] args) throws Exception {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();

        machine.selectCoffee(CoffeeType.LATTE, List.of(ToppingType.CARAMEL));
        machine.insertMoney(100, 1);
        machine.insertMoney(100, 1);
        machine.insertMoney(50, 1);
        machine.makeCoffee();
        machine.dispenseCoffee();

    }
}
