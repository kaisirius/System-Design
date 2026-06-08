package LLD.Problems.LoggingSystem.LogHandlers;

import LLD.Problems.LoggingSystem.enums.LogLevel;
import LLD.Problems.LoggingSystem.models.LogConfig;

public abstract class LogHandler {
  protected LogLevel level;
  protected LogHandler nextLogger;
  protected LogConfig config;

  public LogHandler(LogLevel lvl, LogConfig cfg) {
    level = lvl;
    config = cfg;
    nextLogger = null;
  }

  public void setConfig(LogConfig cfg) {
    config = cfg;
  }

  public void setNextLogger(LogHandler nxt) {
    nextLogger = nxt;
  }

  public LogLevel getLevel() {
    return level;
  }

  public LogHandler getNextHandler() {
    return nextLogger;
  }

  public LogConfig getConfig() {
    return config;
  }

  public void logMessage(LogLevel logLevel, String message) {
    if(this.level == logLevel) {
      // then only we will allow to process else go to next
      log(message);
    } else if(nextLogger != null) {
      nextLogger.logMessage(logLevel, message);
    }
  }

  protected abstract void log(String message);

}
