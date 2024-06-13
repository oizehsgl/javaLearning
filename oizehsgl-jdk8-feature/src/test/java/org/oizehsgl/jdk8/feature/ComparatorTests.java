package org.oizehsgl.jdk8.feature;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

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
