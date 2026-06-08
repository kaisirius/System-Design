package LLD.Problems.LoggingSystem.LogAppenders;

import LLD.Problems.LoggingSystem.interfaces.ILogAppender;
import LLD.Problems.LoggingSystem.models.LogMessage;

public class FileAppender implements ILogAppender {
  @Override
  public void append(LogMessage message) {
    System.out.println("Log appended to file.");
  }
}
