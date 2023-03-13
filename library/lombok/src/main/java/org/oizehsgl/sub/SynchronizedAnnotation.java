package org.oizehsgl.sub;

import lombok.Synchronized;

/**
 * Synchronized
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class SynchronizedAnnotation {
    static Integer integer = 0;

    @Synchronized
    public void addInteger() {
        integer++;
    }
}
