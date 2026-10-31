
public class EmailNotification implements INotification {
  @Override 
  public void send(String msg) {
    System.out.println("Email msg " + msg );
  }
}
