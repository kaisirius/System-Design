package LLD.Problems.LoggingSystem.models;

import LLD.Problems.LoggingSystem.interfaces.ILogAppender;

public class LogConfig {
  private ILogAppender appender;
  // can have LogFormatter and so on to extend this class
  public LogConfig(ILogAppender appender) {
    this.appender = appender;
  }

  public ILogAppender getAppender() {
    return appender;
  }
}
