import LLD.Problems.LoggingSystem.LogAppenders.FileAppender;
import LLD.Problems.LoggingSystem.LogHandlers.DebugLogHandler;
import LLD.Problems.LoggingSystem.LogHandlers.ErrorLogHandler;
import LLD.Problems.LoggingSystem.LogHandlers.InfoLogHandler;
import LLD.Problems.LoggingSystem.LogHandlers.LogHandler;
import LLD.Problems.LoggingSystem.LogHandlers.WarnLogHandler;
import LLD.Problems.LoggingSystem.enums.LogLevel;
import LLD.Problems.LoggingSystem.interfaces.ILogAppender;
import LLD.Problems.LoggingSystem.models.LogConfig;

public class App {
    public static void main(String[] args) throws Exception {
        
        ILogAppender fileAppender = new FileAppender();

        LogConfig cfg = new LogConfig(fileAppender);

        LogHandler infoHandler = new InfoLogHandler(LogLevel.INFO, cfg);
        LogHandler debugHandler = new DebugLogHandler(LogLevel.DEBUG, cfg);
        LogHandler warnHandler = new WarnLogHandler(LogLevel.WARN, cfg);
        LogHandler errorHandler = new ErrorLogHandler(LogLevel.ERROR, cfg);

        infoHandler.setNextLogger(debugHandler);
        debugHandler.setNextLogger(warnHandler);
        warnHandler.setNextLogger(errorHandler);

        infoHandler.logMessage(LogLevel.WARN, "This is a warning message");
    }
}
