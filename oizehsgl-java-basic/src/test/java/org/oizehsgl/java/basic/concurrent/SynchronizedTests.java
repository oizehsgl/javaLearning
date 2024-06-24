package org.oizehsgl.java.basic.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
public class SynchronizedTests {
  @Test
  public void test() throws ExecutionException, InterruptedException {
    String s1 = "KEY";
    String s2 =new String( "KEY");
    String s3 = "KEY";
    CompletableFuture.allOf(
            CompletableFuture.runAsync(() -> testSynchronized(s1,1)),
            CompletableFuture.runAsync(() -> testSynchronized(s2,2)),
            CompletableFuture.runAsync(() -> testSynchronized(s3,3)))
        .get();
  }

  @SneakyThrows
  public void testSynchronized(String key, Integer id) {
    //synchronized (key) {
      synchronized (key.intern()) {
      TimeUnit.SECONDS.sleep(2);
      System.out.println(key + id);
    }
  }
}
