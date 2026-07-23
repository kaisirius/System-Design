package LLD.Problems.PubSubSystem.interfaces;

import LLD.Problems.PubSubSystem.models.Message;

public interface ISubscriber {
  public void onMessage(Message msg);
}
