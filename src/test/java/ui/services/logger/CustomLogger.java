package ui.services.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class creates custom Logger
 *
 * @author Vyacheslav Milashov
 */
public class CustomLogger {
    private static final Logger LOG = Logger.getLogger(CustomLogger.class);
    private static final String CLASS_NAME = CustomLogger.class.getName();

    private static CustomLogger customLogger;

    /**
     * Method creates CustomLogger instance. If it exists, method returns
     * existed one
     *
     * @return CustomLogger
     */
    public static CustomLogger getLogger() {
        if (customLogger == null) {
            customLogger = new CustomLogger();
        }
        return customLogger;
    }

    /**
     * Method returns root Logger instance
     *
     * @return Logger
     */
    public static Logger getRootLogger() {
        return Logger.getRootLogger();
    }

    /**
     * Method logs at Step level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void step(String message) {
        String finalMessage = message;
        logAtLevel(StepLevel.STEP, finalMessage);
    }

    /**
     * Method logs at ErStepror level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void step(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        step(message);
    }

    /**
     * Format message with dates
     * 
     * @param formatPattern
     * @param args
     * @return
     */
    private static String formatMessage(String formatPattern, Object... args) {
        return String.format(formatPattern, args);
    }

    /**
     * Method logs at Error level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void error(String message) {
        logAtLevel(Level.ERROR, message);
    }

    /**
     * Method logs at Error level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void error(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        error(message);
    }

    /**
     * Method logs at Info level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void info(String message) {
        logAtLevel(Level.INFO, message);
    }

    /**
     * Method logs at Info level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void info(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        info(message);
    }

    /**
     * Method logs at Debug level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void debug(String message) {
        logAtLevel(Level.DEBUG, message);
    }

    /**
     * Method logs at Debug level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void debug(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        debug(message);
    }

    /**
     * Method logs at Trace level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void trace(String message) {
        logAtLevel(Level.TRACE, message);
    }

    /**
     * Method logs at Trace level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void trace(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        trace(message);
    }

    /**
     * Method logs at Warn level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void warn(String message) {
        logAtLevel(Level.WARN, message);
    }

    /**
     * Method logs at Warn level with String.format
     *
     * @param formatPattern
     *            String format pattern
     * @param args
     *            format arguments
     */
    public void warn(String formatPattern, Object... args) {
        String message = formatMessage(formatPattern, args);
        warn(message);
    }

    /**
     * Method logs at Fatal level
     *
     * @param message
     *            Message, which will be shown in log
     */
    public void fatal(String message) {
        logAtLevel(Level.FATAL, message);
    }

    /**
     * Method returns original Logger instance
     *
     * @return Logger
     */
    public Logger getOriginalLogger() {
        return LOG;
    }

    /**
     * Method sends a message to the log according to Level value
     *
     * @return Logger
     */
    private static synchronized void logAtLevel(Level level, Object message) {
        LOG.log(CLASS_NAME, level, message, null);
    }
}