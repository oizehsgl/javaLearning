package org.oizehsgl.sub;

/**
 * Cleanup
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class CleanupAnnotation implements AutoCloseable {
    @Override
    public void close() {
        System.out.printf("close: %s%n", this);
    }
}
