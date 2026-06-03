package LLD.Problems.VendingMachine.state;

import LLD.Problems.VendingMachine.models.VendingMachine;
import LLD.Problems.VendingMachine.state.interfaces.IMachineState;

public class AddingMoneyState implements IMachineState {
  @Override
  public void selectItem(VendingMachine machine, String code) {
    System.out.println("Item already selected. Please insert total item's price money!");
  }

  @Override
  public void insertMoneyInMachine(VendingMachine machine, int value, String typeOfMoney) {
    machine.addBalance(value);
    if(typeOfMoney == "coin") machine.getFundManager().addCoin(value);
    else machine.getFundManager().addNote(value);

    if(machine.getBalanceInserted() >= machine.getSelectedItem().getPrice()) {
      machine.setState(new DispensingItemState());
    }
  }

  @Override
  public void dispenseItem(VendingMachine machine) {
    System.out.println("can't dispense item. Please insert total item's price money!");
  }
}
