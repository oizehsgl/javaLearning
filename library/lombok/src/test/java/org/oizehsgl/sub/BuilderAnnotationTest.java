package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class BuilderAnnotationTest {
    @Test
    public void testBuilder() {
        BuilderAnnotation builderAnnotation = BuilderAnnotation.builder().object("").integer(1).build();
        System.out.println("builderAnnotation = " + builderAnnotation);
    }
}