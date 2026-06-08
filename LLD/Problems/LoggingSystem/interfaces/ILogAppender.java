package LLD.Problems.LoggingSystem.interfaces;

import LLD.Problems.LoggingSystem.models.LogMessage;

public interface ILogAppender {
  public void append(LogMessage message);
}
