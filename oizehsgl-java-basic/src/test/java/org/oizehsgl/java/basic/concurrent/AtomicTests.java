package org.oizehsgl.java.basic.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author oizehsgl
 */
public class AtomicTests {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    AtomicReference<String> atomicReference = new AtomicReference<>();

    @Test
    public void test() {
        //atomicReference.updateAndGet();
    }
}
