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
        System.out.println(fibonacci(50, 0, 1));
    }

    private void stackOverflow(long i) {
        System.out.println(--i);
        if (i > 0) stackOverflow(i);
    }

    private long fibonacci(long i) {
        if (i < 2) return i;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    private long fibonacci(long i, long n1, long n2) {
        if (i == 0) return n1;
        return fibonacci(i - 1, n2, n1 + n2);
    }
}
