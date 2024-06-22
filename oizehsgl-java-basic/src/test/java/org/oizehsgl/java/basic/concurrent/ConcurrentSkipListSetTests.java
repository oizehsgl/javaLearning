package org.oizehsgl.java.basic.concurrent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
// @SpringBootTest
public class ConcurrentSkipListSetTests {
  // 程序会出错
  // private static Set<String> set = new TreeSet<String>();
  // 允许多个线程并发访问修改
  private static Set<Integer> set = new ConcurrentSkipListSet<>();

  @Test
  public void test() {
    Consumer<String> consumer =
        prefix -> {
          for (int i = 1; i < 10; i++) {
            set.add(i % 5);
            set.forEach(
                integer -> {
                  System.out.printf("%s%d, ", prefix, integer);
                });
            System.out.println();
          }
        };
    CompletableFuture<Void> futureA = CompletableFuture.runAsync(() -> consumer.accept("a"));
    CompletableFuture<Void> futureB = CompletableFuture.runAsync(() -> consumer.accept("b"));
    CompletableFuture.allOf(futureA, futureB).join();
    set.forEach(System.out::println);
  }
}
