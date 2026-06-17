package LLD.Problems.ATMSystem.models;

import LLD.Problems.ATMSystem.state.IMachineState;
import LLD.Problems.ATMSystem.state.InsertCardState;

public class ATMSystem {
  // to lazy for singelton
  private CashDispenser cashDispenser;
  private ATMCard insertedCard;
  private String enteredPin;
  private IMachineState state;

  public ATMSystem() {
    cashDispenser = new CashDispenser();
    insertedCard = null;
    enteredPin = null;
    state = new InsertCardState();
  }

  public void insertCard(ATMCard card) {
    this.state.insertCard(this, card);
  }

  public void authenticate() {
    this.state.authenticate(this);
  }

  public void enterPin(String pin) {
    this.state.enterPin(this, pin);
  }

  public void deposit(int creditAmount) {
    this.state.depositOperation(this, creditAmount);
  }

  public void withdraw(int debitAmount) {
    this.state.withdrawOperation(this, debitAmount);
  }


  // GETTERS & SETTERS
  public CashDispenser getCashDispenser() {
    return cashDispenser;
  }

  public ATMCard getInsertedCard() {
    return insertedCard;
  }

  public String getEnteredPin() {
    return enteredPin;
  }

  public void setInsertedCard(ATMCard card) {
    insertedCard = card;
  }

  public void setEnteredPin(String pin) {
    enteredPin = pin;
  }

  public void setStatus(IMachineState newState) {
    state = newState;
  }
}
