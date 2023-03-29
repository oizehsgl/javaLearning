package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class NonNullAnnotationTest {
    @Test
    public void testNonNull(){
        NonNullAnnotation nonNullAnnotation = new NonNullAnnotation();
        nonNullAnnotation.nonNull(nonNullAnnotation);
        try {
            nonNullAnnotation.nonNull(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}