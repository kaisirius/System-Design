import LLD.Problems.VendingMachine.models.Item;
import LLD.Problems.VendingMachine.models.VendingMachine;

public class App {
    public static void main(String[] args) throws Exception {
        
        VendingMachine machine = VendingMachine.getInstance();

        Item item1 = new Item("prod1", "orange juice", "minute maid", 20, "1");
        Item item2 = new Item("prod2", "kurkure", "ITC", 21, "2");
        Item item3 = new Item("prod3", "maggi", "nestle", 12, "3");

        machine.addItemsInInventory(item1);
        machine.addItemsInInventory(item2);
        machine.addItemsInInventory(item3);

        machine.selectItem("1");

        machine.insertNote(10);
        machine.insertCoin(5);
        machine.insertCoin(5);

        machine.dispenseItem();

        machine.selectItem("2");

        machine.insertNote(20);
        machine.insertNote(20);

        machine.dispenseItem();



    }
}
