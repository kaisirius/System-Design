public class StateB implements IState {
  @Override 
  public void next(StateContext context) {
    System.out.println("processing state B and transitioning to next state");
    context.setState(new StateA());
  }
}
