package LLD.Problems.LoggingSystem.models;

import LLD.Problems.LoggingSystem.enums.LogLevel;

public class LogMessage {
  private LogLevel level;
  private String message;
  private long unixTimestamp;

  public LogMessage(LogLevel level, String message, long timestamp) {
    this.level = level;
    this.message = message;
    unixTimestamp = timestamp;
  }

  public LogLevel getLevel() {
    return level;
  }

  public String getMessage() {
    return message;
  }

  public long getTimeStamp() {
    return unixTimestamp;
  }
}
