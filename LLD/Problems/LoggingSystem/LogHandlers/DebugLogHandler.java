package LLD.Problems.LoggingSystem.LogHandlers;

import java.util.Date;

import LLD.Problems.LoggingSystem.enums.LogLevel;
import LLD.Problems.LoggingSystem.models.LogConfig;
import LLD.Problems.LoggingSystem.models.LogMessage;

public class DebugLogHandler extends LogHandler {
  public DebugLogHandler(LogLevel lvl, LogConfig cfg) {
    super(lvl, cfg);
  }

  @Override
  protected void log(String message) {
    // can take formatter from config and get modified message 
    // can add own editing to log "[INFO]: ...message"
    System.out.println("[DEBUG]: " + message);
    LogMessage logMessage = new LogMessage(this.level, message, new Date().getTime());
    this.config.getAppender().append(logMessage);
  }
}
