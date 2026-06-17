package LLD.Problems.ATMSystem.state;

import LLD.Problems.ATMSystem.models.ATMCard;
import LLD.Problems.ATMSystem.models.ATMSystem;

public class PerformOperationState implements IMachineState {
  @Override
  public void insertCard(ATMSystem system, ATMCard card) {
    System.out.println("Card alredy inserted.");
  }

  @Override
  public void authenticate(ATMSystem system) {
    System.out.println("Card alredy authenticated.");
  }

  @Override
  public void enterPin(ATMSystem system, String pin) {
    system.setEnteredPin(pin);
    if(system.getInsertedCard().getPin() != pin) {
      System.out.println("Invalid pin.");
      system.setStatus(new InsertCardState());
    }
  }

  @Override
  public void withdrawOperation(ATMSystem system, int debitAmount) {
    system.getInsertedCard().getBankService().initWithdrawal(system.getInsertedCard().getCardNo(), debitAmount);
    system.getCashDispenser().dispenseCash(debitAmount);
  }

  @Override
  public void depositOperation(ATMSystem system, int creditAmount) {
    system.getInsertedCard().getBankService().initDeposit(system.getInsertedCard().getCardNo(), creditAmount);
    system.getCashDispenser().addCash(creditAmount);
  }

  @Override
  public void getBalance(ATMSystem system) {
    long balance = system.getInsertedCard().getBankService().getBalance(system.getInsertedCard().getCardNo());
    System.out.println("Current balance: " + balance);
  }
}
