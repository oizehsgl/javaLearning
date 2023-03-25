package org.oizehsgl.sub;

/**
 * innerClassDemo
 *
 * @author oizehsgl
 * @since 3/26/23
 */
public class InnerClassDemo {
    private static void method() {
        int i = 0;
        class InnerClass {
            public void innerMethod() {
                System.out.println(i);
            }
        }
    }
}
