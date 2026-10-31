import javax.management.InvalidAttributeValueException;

public interface NotificationFactory {
  
  public static INotification createNotification(String type) throws Exception {
    if(type == "SMS") {
      return new SMSNotification();
    } else if(type == "Email") {
      return new EmailNotification();
    } else {
      throw new InvalidAttributeValueException();
    }
  }
}
