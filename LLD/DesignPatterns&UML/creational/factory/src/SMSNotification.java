
public class SMSNotification implements INotification {
  @Override 
  public void send(String msg) {
    System.out.println("SMS msg " + msg);
  }
}
