package org.oizehsgl.sub;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.deepCopy.DeepCopyDemo;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanCopier;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * deepCopyTest
 *
 * @author oizehsgl
 * @since 3/31/23
 */
@SpringBootTest
public class DeepCopyTest {
    @Test
    public void testDeepCopy() {
        AtomicInteger i = new AtomicInteger(-1);
        DeepCopyDemo deepCopyDemo = DeepCopyDemo.builder().integer(1).string("s").integerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList())).build();
/// error
//        testCglib(deepCopyDemo, (DeepCopyDemo demo) -> {
//            demo.setIntegerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()));
//        });
        testSpring(deepCopyDemo, (DeepCopyDemo demo) -> {
            demo.setIntegerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()));
        });
        testAcl3(deepCopyDemo, (DeepCopyDemo demo) -> {
            demo.setIntegerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()));
        });

        try {
            testJava(deepCopyDemo, (DeepCopyDemo demo) -> {
                demo.setIntegerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void testSpring(DeepCopyDemo deepCopyDemo, Consumer<DeepCopyDemo> consumer) {
        DeepCopyDemo deepCopyDemoCopied = new DeepCopyDemo();
        BeanUtils.copyProperties(deepCopyDemo, deepCopyDemoCopied);
        showDiff(deepCopyDemo, deepCopyDemoCopied, consumer);
    }

    private void testCglib(DeepCopyDemo deepCopyDemo, Consumer<DeepCopyDemo> consumer) {
        BeanCopier beanCopier = BeanCopier.create(DeepCopyDemo.class, DeepCopyTest.class, false);
        DeepCopyDemo deepCopyDemoCopied = new DeepCopyDemo();
        beanCopier.copy(deepCopyDemo, deepCopyDemoCopied, null);
        showDiff(deepCopyDemo, deepCopyDemoCopied, consumer);
    }

    private void testAcl3(DeepCopyDemo deepCopyDemo, Consumer<DeepCopyDemo> consumer) {
        DeepCopyDemo deepCopyDemoCopied = SerializationUtils.clone(deepCopyDemo);
        showDiff(deepCopyDemo, deepCopyDemoCopied, consumer);
    }

    private void testJava(DeepCopyDemo deepCopyDemo, Consumer<DeepCopyDemo> consumer) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(deepCopyDemo);
        out.flush();
        out.close();
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        DeepCopyDemo deepCopyDemoCopied = (DeepCopyDemo) in.readObject();
        in.close();
        showDiff(deepCopyDemo, deepCopyDemoCopied, consumer);
    }

    private void showDiff(DeepCopyDemo deepCopyDemo0, DeepCopyDemo deepCopyDemoCopied, Consumer<DeepCopyDemo> consumer) {
        System.out.println(deepCopyDemoCopied);
        consumer.accept(deepCopyDemo0);
        System.out.println(deepCopyDemoCopied);
    }

}
