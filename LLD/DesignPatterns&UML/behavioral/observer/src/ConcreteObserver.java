public class ConcreteObserver implements IObserver {
  @Override
  public void update() {
    System.out.println("notification sent to observer");
  }
}
