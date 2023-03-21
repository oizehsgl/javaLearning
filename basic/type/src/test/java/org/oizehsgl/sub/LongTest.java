package org.oizehsgl.sub;

import org.junit.Test;

/**
 * longTest
 *
 * @author oizehsgl
 * @since 3/21/23
 */
public class LongTest {
    @Test
    public void testLong() {
        System.out.println(Long.toBinaryString(-1L));
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        System.out.println(Long.toBinaryString(Long.MIN_VALUE>>>10));
    }
}
