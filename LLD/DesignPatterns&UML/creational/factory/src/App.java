public class App {
    public static void main(String[] args) throws Exception {
        INotification notification = NotificationFactory.createNotification("SMS");
        notification.send("factory masti");
    }
}
