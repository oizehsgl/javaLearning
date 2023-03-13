package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class ValueAnnotationTest {
    @Test
    public void testGetter() {
        ValueAnnotation valueAnnotation = new ValueAnnotation("", 1);
        System.out.println("valueAnnotation.getInteger() = " + valueAnnotation.getInteger());
    }

    @Test
    public void testSetter() {
        ValueAnnotation valueAnnotation = new ValueAnnotation("", 1);
        System.out.println("valueAnnotation.getObject() = " + valueAnnotation.getObject());
    }

    @Test
    public void testToString() {
        ValueAnnotation valueAnnotation = new ValueAnnotation("", 1);
        System.out.println("valueAnnotation = " + valueAnnotation);
    }

    @Test
    public void testEqualsAndHashCode() {
        ValueAnnotation valueAnnotation1 = new ValueAnnotation("", 1);
        System.out.println("valueAnnotation.hashCode() = " + valueAnnotation1.hashCode());
        ValueAnnotation valueAnnotation2 = new ValueAnnotation("", 1);
        System.out.println("valueAnnotation.hashCode() = " + valueAnnotation2.hashCode());
    }
}