package org.oizehsgl.sub;

/**
 * methodNameDemo
 *
 * @author oizehsgl
 * @since 4/21/23
 */
public class MethodNameDemo {
    public static void method() {
        System.out.println("can you get my name?");
    }
    public static Integer method(String s) {
        System.out.println("can you get my name?");
        return null;
    }
    public void method(Integer integer) {
        System.out.println("can you get my name?");
    }

    public void method(Void v) {
        System.out.printf("get it: %s%n",Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
