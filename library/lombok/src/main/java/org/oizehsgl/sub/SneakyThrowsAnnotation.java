package org.oizehsgl.sub;

import lombok.SneakyThrows;

/**
 * SneakyThrows
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class SneakyThrowsAnnotation extends Throwable {
    @SneakyThrows(Exception.class)
    public void throwException() {
        throw new Exception();
    }
}
