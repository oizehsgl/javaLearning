package org.oizehsgl.sub;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        System.out.println("注释");
        System.out.printf("%s: %s%n", "单行", "//");
        System.out.printf("%s: %s%n", "多行", "\n/*\n*\n*/");
        System.out.printf("%s: %s%n", "文档行", "\n/**\n*\n*/");
    }
}
