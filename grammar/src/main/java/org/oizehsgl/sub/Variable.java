package org.oizehsgl.sub;

/**
 * 变量
 *
 * @author oizehsgl
 * @since 2023/1/3
 */
public class Variable {
    public static void main(String[] args) {
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "成员变量","类中{}","堆","同实例");
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "局部变量","方法中{{}}","栈","同方法");
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "静态变量","类中{}","方法区","同类");
    }
}
