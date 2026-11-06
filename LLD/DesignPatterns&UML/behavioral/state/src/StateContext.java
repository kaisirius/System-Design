public class StateContext {
  private IState currentState;

  public StateContext() {
    currentState = new StateA();
  }

  public void setState(IState state) {
    currentState = state;
  }

  public void handleSomething() {
    currentState.next(this);
  }
}
