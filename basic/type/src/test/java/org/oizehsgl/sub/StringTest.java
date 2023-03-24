package org.oizehsgl.sub;

import org.junit.Test;

/**
 * stringTest
 *
 * @author oizehsgl
 * @since 3/24/23
 */
public class StringTest {
    @Test
    public void testString() {
        // TODO 未复现 深入理解java虚拟机_2 listing 2-7
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
