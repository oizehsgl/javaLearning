package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class DataAnnotationTest {

    @Test
    public void testGetter() {
        DataAnnotation dataAnnotation = DataAnnotation.of("",1);
        System.out.println("dataAnnotation.getInteger() = " + dataAnnotation.getInteger());
    }
    @Test
    public void testSetter() {
        DataAnnotation dataAnnotation = DataAnnotation.of("",1);
        dataAnnotation.setObject("object");
        System.out.println("dataAnnotation.getObject() = " + dataAnnotation.getObject());
    }

    @Test
    public void testToString() {
        DataAnnotation dataAnnotation = DataAnnotation.of("",1);
        System.out.println("dataAnnotation = " + dataAnnotation);
    }

    @Test
    public void testEqualsAndHashCode() {
        DataAnnotation dataAnnotation1 = DataAnnotation.of("",1);
        System.out.println("dataAnnotation.hashCode() = " + dataAnnotation1.hashCode());
        DataAnnotation dataAnnotation2 = DataAnnotation.of("",2);
        System.out.println("dataAnnotation.hashCode() = " + dataAnnotation2.hashCode());
    }
}