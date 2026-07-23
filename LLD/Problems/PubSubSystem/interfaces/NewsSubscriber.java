package LLD.Problems.PubSubSystem.interfaces;

import LLD.Problems.PubSubSystem.models.Message;

public class NewsSubscriber implements ISubscriber {
  @Override
  public void onMessage(Message msg) {
    System.out.println("[News subscriber] received a message on topic: " + msg.getTopic().getTopicName() + " from publisher ID: " + msg.getPublisher().getId());
    System.out.println("Message payload is: " + msg.getPayload());
  }
}
