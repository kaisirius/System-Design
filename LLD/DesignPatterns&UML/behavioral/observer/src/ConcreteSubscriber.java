public class ConcreteSubscriber implements IObserver {
  @Override 
  public void update() {
    System.out.println("Notification sent to subscriber");
  }
}
