package org.oizehsgl.sub;

/**
 * fileLogger
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    @Override
    protected void print(String message) {
        System.out.printf("%s: %s%n", this.getClass().getSimpleName(), message);
    }
}
