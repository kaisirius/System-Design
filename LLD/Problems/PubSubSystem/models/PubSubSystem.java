package LLD.Problems.PubSubSystem.models;

import java.util.HashMap;
import java.util.Map;

import LLD.Problems.PubSubSystem.interfaces.ISubscriber;

public class PubSubSystem {
  private Map<Integer, Topic> topicsListed;
  private Map<Integer, Publisher> publishersListed;
  private static PubSubSystem instance;

  private PubSubSystem() {
    topicsListed = new HashMap<>();
    publishersListed = new HashMap<>();
    instance = null;
  }

  public static synchronized PubSubSystem getInstance() {
    if(instance == null) {
      synchronized(PubSubSystem.class) {
        if(instance == null) {
          instance = new PubSubSystem();
        }
      }
    }

    return instance;
  }

  public int createTopic(String topicName) {
    Topic topic = new Topic(topicName);
    topicsListed.put(topic.getId(), topic);
    return topic.getId();
  }

  public void addPublisher(Publisher pub) {
    publishersListed.put(pub.getId(), pub);
  }

  public Message createMessage(String msg, int publisherId, int topicId) {
    if(publishersListed.containsKey(publisherId) && topicsListed.containsKey(topicId)) {
      return new Message(msg, publishersListed.get(publisherId), topicsListed.get(topicId));
    } else {
      System.out.println("Invalide publisherID or topicID");
      return null;
    }
  }

  public void publish(Message msg) {
    if(topicsListed.containsKey(msg.getTopic().getId())) {
      topicsListed.get(msg.getTopic().getId()).broadcast(msg);
    } else {
      System.out.println("Invalid message topic");
    }
  }

  public void subscribe(int topicId, ISubscriber subscriber) {
    if(topicsListed.containsKey(topicId)) {
      topicsListed.get(topicId).addSubscriber(subscriber);
    } else {
      System.out.println("Invalid topicID.");
    }
  }

  public void unsubscribe(int topicId, ISubscriber subscriber) {
    if(topicsListed.containsKey(topicId)) {
      topicsListed.get(topicId).removeSubscriber(subscriber);
    } else {
      System.out.println("Invalid topicID.");
    }
  }
}
