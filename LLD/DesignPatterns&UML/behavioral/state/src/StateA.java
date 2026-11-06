public class StateA implements IState {
  @Override
  public void next(StateContext context) {
    // do logical op
    System.out.println("processing state A and transitioning to next state");
    context.setState(new StateB());
  }
}
