package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.deepCopy.DeepCopyDemo;
import org.oizehsgl.sub.deepCopy.IInterface;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
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
        DeepCopyDemo deepCopyDemo = DeepCopyDemo.builder()
                .integer(1)
                .string("1")
                .integerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()))
                .deepCopyDemo(DeepCopyDemo.builder()
                        .integer(2)
                        .string("2")
                        .integerList(Stream.iterate(0, x -> x + 1).limit(2).collect(Collectors.toList()))
                        .build()
                )
                .build();
        testT(deepCopyDemo, DeepCopyDemo::new, (DeepCopyDemo demo) -> {
            demo.setIntegerList(Stream.iterate((i.incrementAndGet()) * 2, x -> x + 1).limit(2).collect(Collectors.toList()));
        });
    }

    private <T extends IInterface> void testT(T tSrc, Supplier<T> supplier, Consumer<T> consumer) {
        T tDst = supplier.get();
        //BeanUtils.copyProperties(tSrc, tDst);
        //tDst = SerializationUtils.clone(tSrc);
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(tSrc);
            out.flush();
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            tDst = (T) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("src: %s dst: %s%n", tSrc, tDst);
        tSrc.setString("");
        tSrc.addList0();
        tSrc.getDeepCopyDemo().setString("");
        System.out.printf("src: %s dst: %s%n", tSrc, tDst);
    }
}
