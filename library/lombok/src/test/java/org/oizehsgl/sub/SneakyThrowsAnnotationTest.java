package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class SneakyThrowsAnnotationTest {
    @Test
    public void testSneakyThrows() {
        SneakyThrowsAnnotation sneakyThrowsAnnotation = new SneakyThrowsAnnotation();
        try {
            sneakyThrowsAnnotation.throwException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sneakyThrowsAnnotation = " + sneakyThrowsAnnotation);
    }
}