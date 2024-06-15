package org.oizehsgl.java.basic.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
class SubCustomConstantTest {

    @Test
    public void test() {
        // 子类不定义直接使用父类属性
        System.out.println(SubCustomConstant.INT);
        // 子类定义后覆盖父类属性
        System.out.println(SubCustomConstant.STRING);
    }
}