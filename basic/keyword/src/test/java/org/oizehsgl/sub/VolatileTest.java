package org.oizehsgl.sub;

import org.junit.Test;

/**
 * volatile test
 *
 * @author oizehsgl
 * @since 3/6/23
 */
public class VolatileTest {

    @Test
    public void testReordering() {
        Volatile aVolatile = new Volatile();
        int count = 0;
        while (true) {
            count++;
            try {
                int sum = aVolatile.reordering();
                if (sum == 0) {
                    System.out.printf("%-10d %d%n", count, sum);
                    break;
                }
                System.out.printf("%-10d %d%n", count, sum);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
