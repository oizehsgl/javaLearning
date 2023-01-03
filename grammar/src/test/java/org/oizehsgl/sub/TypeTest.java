package org.oizehsgl.sub;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * @author oizehsgl
 * @since 2022/12/29
 */
public class TypeTest {
    @Test
    public void testSize() {
        getSize(byte.class,100000000);
        getSize(boolean.class,100000000);
        getSize(short.class,100000000);
        getSize(char.class,100000000);
        getSize(int.class,100000000);
        getSize(float.class,100000000);
        getSize(long.class,100000000);
        getSize(double.class,100000000);
    }
    private static void  getSize(Class type,int length) {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        Object array=Array.newInstance(type,length);
        System.gc();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("类型%-4s\t总数%d\t总占用%s\t平均占用%s\n", type.getName(),length,endMem-startMem,(endMem-startMem)/(double)length);
    }
    byte byteDefault;
    short shortDefault;
    int intDefault;
    long longDefault;
    boolean booleanDefault;
    char charDefault;
    float floatDefault;
    double doubleDefault;

    @Test
    public void testDefault() {
        System.out.println("byteDefault = " + byteDefault);
        System.out.println("shortDefault = " + shortDefault);
        System.out.println("intDefault = " + intDefault);
        System.out.println("longDefault = " + longDefault);
        System.out.println("booleanDefault = " + booleanDefault);
        System.out.println("charDefault = " + charDefault);
        System.out.println("floatDefault = " + floatDefault);
        System.out.println("doubleDefault = " + doubleDefault);
    }
}