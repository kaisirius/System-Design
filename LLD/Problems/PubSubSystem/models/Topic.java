package LLD.Problems.PubSubSystem.models;

import java.util.HashSet;
import java.util.Set;

import LLD.Problems.PubSubSystem.interfaces.ISubscriber;

public class Topic {
  private int topicId;
  private static int autoIncrementor = 1;
  private String topicName;
  private Set<ISubscriber> subscribers;

  public Topic(String name) {
    topicName = name;
    topicId = autoIncrementor++;
    subscribers = new HashSet<>();
  } 

  public String getTopicName() {
    return topicName;
  }

  public int getId() {
    return topicId;
  }

  public void addSubscriber(ISubscriber sub) {
    subscribers.add(sub);
  }

  public void removeSubscriber(ISubscriber sub) {
    if(subscribers.contains(sub)) {
      System.out.println("Removing subscriber...");
      subscribers.remove(sub);
    } else {
      System.out.println("Invalid subscriber");
    }
  }

  public void broadcast(Message msg) {
    for(ISubscriber sub: subscribers) {
      sub.onMessage(msg);
    }
  }
}
