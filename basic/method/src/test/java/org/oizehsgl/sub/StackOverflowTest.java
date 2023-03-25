package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;

/**
 * stackOverflowTest
 *
 * @author oizehsgl
 * @since 3/25/23
 */
public class StackOverflowTest {
    @Test
    public void testStackOverflow() {
        Integer i = (1<<13);
        stackOverflow(i);
    }

    private void stackOverflow(int i) {
        System.out.println(--i);
        if(i>0) stackOverflow(i);
    }
}
