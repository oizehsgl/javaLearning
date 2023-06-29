package com.example.keyword.keywordDatatype;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
public abstract class Datatype<T> {
    T data;

    public abstract void test();

    public void test(T t1, T t2) {
        data = t1;
        System.out.println(data);
        data = t2;
        System.out.println(data);
        System.out.println(ClassLayout.parseInstance(data).toPrintable());
        System.out.println(GraphLayout.parseInstance(data).toPrintable());
    }
}
