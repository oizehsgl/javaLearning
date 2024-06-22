package org.oizehsgl.java.basic;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
public class ComparatorTests {
    @Test
    public void test() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }
}
