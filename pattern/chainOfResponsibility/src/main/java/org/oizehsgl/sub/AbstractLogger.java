package org.oizehsgl.sub;

import java.util.Objects;

/**
 * abstractLogger
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public abstract class AbstractLogger {
    protected LoggerLevel loggerLevel;
    public AbstractLogger nextAbstractLogger;

    public void setNextAbstractLogger(AbstractLogger abstractLogger) {
        this.nextAbstractLogger = abstractLogger;
    }

    public void loggerMessage(LoggerLevel loggerLevel, String message) {
        if (this.loggerLevel.level <= loggerLevel.level) {
            print(message);
        }
        if (Objects.nonNull(nextAbstractLogger)) {
            nextAbstractLogger.loggerMessage(loggerLevel, message);
        }
    }

    abstract protected void print(String message);
}
