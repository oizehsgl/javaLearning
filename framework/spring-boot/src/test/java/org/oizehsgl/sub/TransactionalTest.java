package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.jpa.TableEntity;
import org.oizehsgl.sub.transcation.TransactionalDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * transactionalTest
 *
 * @author oizehsgl
 * @since 3/22/23
 */
@SpringBootTest
public class TransactionalTest {
    @Autowired
    private TransactionalDemo transactionalDemo;

    @Test
    public void testTransactional1() {
        test(transactionalDemo::testTransactional1, true);
    }

    @Test
    public void testTransactional2() {
        test(transactionalDemo::testTransactional2, false);
    }

    @Test
    public void testTransactional3() {
        test(transactionalDemo::testTransactional3, false);
    }

    @Test
    public void testTransactional4() {
        test(transactionalDemo::testTransactional4, true);
    }

    private void test(Runnable runnable, Boolean b) {
        TableEntity tableEntity1 = transactionalDemo.get();
        try {
            runnable.run();
        } catch (Exception e) {
        }
        TableEntity tableEntity2 = transactionalDemo.get();
        System.out.println("tableEntity1 = " + tableEntity1);
        System.out.println("tableEntity2 = " + tableEntity2);
        Assert.isTrue(tableEntity1.equals(tableEntity2) == b);
        transactionalDemo.reset();
    }
}
