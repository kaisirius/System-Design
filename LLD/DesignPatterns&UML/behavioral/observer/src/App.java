public class App {
    public static void main(String[] args) throws Exception {
       Publisher publisher = new Publisher();
       publisher.addSubscriber(new ConcreteObserver());
       publisher.addSubscriber(new ConcreteSubscriber());
       
       publisher.notifySubscribers();
    }
}
