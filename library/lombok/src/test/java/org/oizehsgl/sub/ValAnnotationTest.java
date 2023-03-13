package org.oizehsgl.sub;

import lombok.val;
import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class ValAnnotationTest {

    @Test
    public void testValAnnotation(){
        val val = new ValAnnotation();
        System.out.println(val.getClass());
    }
}