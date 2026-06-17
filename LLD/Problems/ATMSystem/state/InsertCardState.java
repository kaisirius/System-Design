package LLD.Problems.ATMSystem.state;

import LLD.Problems.ATMSystem.models.ATMCard;
import LLD.Problems.ATMSystem.models.ATMSystem;

public class InsertCardState implements IMachineState {
  @Override
  public void insertCard(ATMSystem system, ATMCard card) {
    system.setInsertedCard(card);
    system.setStatus(new AuthenticateUserState());
  }

  @Override
  public void authenticate(ATMSystem system) {
    System.out.println("Inset card first please.");
  }

  @Override
  public void enterPin(ATMSystem system, String pin) {
    System.out.println("Inset card first please.");
  }

  @Override
  public void withdrawOperation(ATMSystem system, int debitAmount) {
    System.out.println("Inset card first please.");
  }

  @Override
  public void depositOperation(ATMSystem system, int creditAmount) {
    System.out.println("Inset card first please.");
  }

  @Override
  public void getBalance(ATMSystem system) {
    System.out.println("Inset card first please.");
  }
}
