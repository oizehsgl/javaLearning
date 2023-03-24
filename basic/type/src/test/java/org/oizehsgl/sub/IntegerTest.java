package org.oizehsgl.sub;

import org.junit.Test;

/**
 * integerTest
 *
 * @author oizehsgl
 * @since 3/24/23
 */
public class IntegerTest {
    @Test
    public void testInteger() {
        testAutoBox(1, 1);
        testAutoBox(new Integer(1), new Integer(1));
        testAutoBox(1_000, 1_000);
    }

    private void testAutoBox(Integer i1, Integer i2) {
        System.out.println(i1 == i2);
    }
}
