package org.oizehsgl.sub;

import org.junit.Test;

/**
 * @author oizehsgl
 * @since 2023/1/3
 */
public class VariableTest {

    // 静态变量
    static int staticVar;
    // 成员变量
    int memberVar;

    @Test
    public void test() {
        int localVar;
        localVar=0;
        System.out.println("staticVar = " + staticVar);
        System.out.println("memberVar = " + memberVar);
        System.out.println("localVar = " + localVar);
    }
}