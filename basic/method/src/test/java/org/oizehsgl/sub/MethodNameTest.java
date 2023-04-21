package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * methodNameTest
 *
 * @author oizehsgl
 * @since 4/21/23
 */
public class MethodNameTest {
    @Test
    public void test() {
        MethodNameDemo methodNameDemo = new MethodNameDemo();
        methodNameDemo.method(Void.class.cast(null));
    }

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Serializable s = (BiConsumer<MethodNameDemo, Integer> & Serializable) MethodNameDemo::method;
        //Serializable s = (Runnable & Serializable) MethodNameDemo::method;
        Serializable s = (Function<String,Integer> & Serializable) MethodNameDemo::method;
        Method method = s.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda) method.invoke(s);
        System.out.printf("%s %s%n", serializedLambda.getImplClass(), serializedLambda.getImplMethodName());
    }
}