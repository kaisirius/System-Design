import java.util.ArrayList;
import java.util.List;

public class Publisher {
  private List<IObserver> subscribers;

  public Publisher() {
    subscribers = new ArrayList<>();
  }

  public void addSubscriber(IObserver observer) {
    subscribers.add(observer);
  }

  public void removeSubscriber(IObserver observer) {
    subscribers.remove(observer);
  }

  public void notifySubscribers() {
    for(IObserver subscriber: subscribers) {
      subscriber.update();
    }
  }
}
