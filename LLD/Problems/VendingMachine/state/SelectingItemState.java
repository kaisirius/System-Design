package LLD.Problems.VendingMachine.state;

import LLD.Problems.VendingMachine.models.VendingMachine;
import LLD.Problems.VendingMachine.state.interfaces.IMachineState;

public class SelectingItemState implements IMachineState {
  @Override
  public void selectItem(VendingMachine machine, String code) {
    machine.setSelectedItemCode(code);
    machine.setState(new AddingMoneyState());
  }

  @Override
  public void insertMoneyInMachine(VendingMachine machine, int value, String typeOfMoney) {
    System.out.println("Please select item before inserting money!");
  }

  @Override
  public void dispenseItem(VendingMachine machine) {
    System.out.println("Please select item before dispensing any item!");
  }
}
