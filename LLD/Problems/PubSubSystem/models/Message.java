package LLD.Problems.PubSubSystem.models;

import java.time.LocalDateTime;

public class Message {
  private LocalDateTime timestamp;
  private String payload;
  private Publisher publisher;
  private Topic topic;

  public Message(String msgContent, Publisher publishedBy, Topic topic) {
    timestamp = LocalDateTime.now();
    payload = msgContent;
    publisher = publishedBy;
    this.topic = topic;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getPayload() {
    return payload;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public Topic getTopic() {
    return topic;
  }
}
