package org.oizehsgl.sub;

/**
 * consoleLogger
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    @Override
    protected void print(String message) {
        System.out.printf("%s: %s%n", this.getClass().getSimpleName(), message);
    }
}
