package org.oizehsgl.sub;

/**
 * loggerLevel
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public enum LoggerLevel {
    ERROR(3), WARN(2), DEBUG(1);

    LoggerLevel(int level) {
        this.level=level;
    }
    int level;
}
