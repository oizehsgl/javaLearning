package org.oizehsgl.sub;

import org.junit.Test;

/**
 * chainOfResponsibilityTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class ChainOfResponsibilityTest {
    @Test
    public void testChainOfResponsibility() {
        AbstractLogger accidentLogger = new AccidentLogger(LoggerLevel.ERROR);
        AbstractLogger consoleLogger = new ConsoleLogger(LoggerLevel.WARN);
        AbstractLogger fileLogger = new FileLogger(LoggerLevel.DEBUG);
        fileLogger.setNextAbstractLogger(consoleLogger);
        consoleLogger.setNextAbstractLogger(accidentLogger);
        fileLogger.loggerMessage(LoggerLevel.DEBUG,LoggerLevel.DEBUG.name());
        fileLogger.loggerMessage(LoggerLevel.WARN,LoggerLevel.WARN.name());
        fileLogger.loggerMessage(LoggerLevel.ERROR,LoggerLevel.ERROR.name());
    }
}
