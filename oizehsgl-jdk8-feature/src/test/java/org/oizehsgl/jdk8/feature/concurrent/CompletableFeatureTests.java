package org.oizehsgl.jdk8.feature.concurrent;

import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CompletableFeatureTests {
  Supplier<Double> supplier =
      () -> {
        System.out.println(Thread.currentThread() + " start,time->" + LocalTime.now());
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread() + " exit,time->" + LocalTime.now());
        return 1.2;
      };
  Function<Double, String> function =
      (d) -> {
        try {
          TimeUnit.SECONDS.sleep(3);
          return "String" + d;
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };
  Function<Throwable, Double> exceptionFunction =
      (e) -> {
        try {
          System.out.println(Thread.currentThread() + e.getMessage());
          TimeUnit.SECONDS.sleep(3);
          return 100.0D;
        } catch (InterruptedException e1) {
          throw new RuntimeException(e1);
        }
      };

  Consumer<Double> doubleConsumer =
      (d) -> {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };
  Consumer<String> consumer =
      (d) -> {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };
  Runnable runnable =
      () -> {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };

  @Test
  void supplyAsyncAndRunAsyncTest() throws ExecutionException, InterruptedException {
    CompletableFuture<Double> completableFuture1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(supplier::get);
    System.out.println("main thread start,time->" + LocalTime.now());
    // System.out.println("run result->" + completableFuture1.get());
    // System.out.println("run result->" + completableFuture2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
    TimeUnit.SECONDS.sleep(5);
  }

  @Test
  void supplyAsyncAndRunAsync() throws ExecutionException, InterruptedException {
    CompletableFuture<Double> completableFuture1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(supplier::get);
    System.out.println("main thread start,time->" + LocalTime.now());
    System.out.println("run result->" + completableFuture1.get());
    System.out.println("run result->" + completableFuture2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void thenApply() throws Exception {
    ForkJoinPool pool = new ForkJoinPool();
    // 创建异步执行任务:
    CompletableFuture<Double> cf = CompletableFuture.supplyAsync(supplier);
    // cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
    // thenApply这里实际创建了一个新的CompletableFuture实例
    CompletableFuture<String> cf2 = cf.thenApply(function);
    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void thenApplyAsync() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf = CompletableFuture.supplyAsync(supplier);
    // cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
    // thenApply这里实际创建了一个新的CompletableFuture实例
    CompletableFuture<String> cf2 = cf.thenApplyAsync(function);
    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
    TimeUnit.SECONDS.sleep(10);
  }

  @Test
  public void thenAcceptAndThenRun() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    // cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
    // thenApply这里实际创建了一个新的CompletableFuture实例
    CompletableFuture<String> cf2 = cf1.thenApply(function);
    CompletableFuture<Void> cf3 = cf2.thenAccept(consumer);
    CompletableFuture<Void> cf4 = cf3.thenRun(runnable);

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("run result->" + cf3.get());
    System.out.println("run result->" + cf4.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void exceptionally() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    // 有异常执行这个
    CompletableFuture<Double> cf2 = cf1.exceptionally(exceptionFunction);
    // 无异常执行这个
    CompletableFuture<Void> cf3 = cf1.thenAccept(doubleConsumer);

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("run result->" + cf3.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void whenComplete() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<Double> cf2 =
        cf1.whenComplete(
            (d, e) -> {
              if (Objects.isNull(e)) {
                System.out.println("no error!");
              } else {
                e.printStackTrace();
              }
            });

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void handle() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<String> cf2 =
        cf1.handle(
            (d, e) -> {
              if (Objects.isNull(e)) {
                System.out.println("no error!");
              } else {
                e.printStackTrace();
              }
              return "";
            });

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void thenCombine() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<String> cf3 =
        cf1.thenCombine(
            cf2,
            (a, b) -> {
              return "" + a + b;
            });
    CompletableFuture<Void> cf4 =
        cf1.thenAcceptBoth(
            cf2,
            (a, b) -> {
              System.out.println("--" + a + "--" + b);
            });
    CompletableFuture<Void> cf5 =
        cf1.runAfterBoth(
            cf2,
            () -> {
              System.out.println("--" + "--");
            });

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("run result->" + cf3.get());
    System.out.println("run result->" + cf4.get());
    System.out.println("run result->" + cf5.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void either() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);
    CompletableFuture<Double> cf2 =
        CompletableFuture.supplyAsync(
            () -> {
              Double d = supplier.get();
              try {
                TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("999999999999999999999999999999999999999");
              return d;
            });
    CompletableFuture<String> cf3 =
        cf1.applyToEither(
            cf2,
            (a) -> {
              return "" + a + 100;
            });
    CompletableFuture<Void> cf4 =
        cf1.acceptEither(
            cf2,
            (a) -> {
              System.out.println("--" + a + "--");
            });
    CompletableFuture<Void> cf5 =
        cf1.runAfterEither(
            cf2,
            () -> {
              System.out.println("--" + "--");
            });

    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("run result->" + cf3.get());
    System.out.println("run result->" + cf4.get());
    System.out.println("run result->" + cf5.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void compose() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(supplier);

    CompletableFuture<String> cf2 =
        cf1.thenCompose(
            (param) -> {
              System.out.println(
                  Thread.currentThread() + " start job2,time->" + System.currentTimeMillis());
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
              }
              System.out.println(
                  Thread.currentThread() + " exit job2,time->" + System.currentTimeMillis());
              return CompletableFuture.supplyAsync(
                  () -> {
                    System.out.println(
                        Thread.currentThread() + " start job3,time->" + System.currentTimeMillis());
                    try {
                      Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(
                        Thread.currentThread() + " exit job3,time->" + System.currentTimeMillis());
                    return "job3 test";
                  });
            });
    System.out.println("main thread start cf.get(),time->" + LocalTime.now());
    // 等待子任务执行完成
    System.out.println("run result->" + cf1.get());
    System.out.println("main thread start cf2.get(),time->" + LocalTime.now());
    System.out.println("run result->" + cf2.get());
    System.out.println("main thread exit,time->" + LocalTime.now());
  }

  @Test
  public void all() throws Exception {
    // 创建异步执行任务:
    CompletableFuture<Double> cf =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println(
                  Thread.currentThread() + " start job1,time->" + System.currentTimeMillis());
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
              }
              System.out.println(
                  Thread.currentThread() + " exit job1,time->" + System.currentTimeMillis());
              return 1.2;
            });
    CompletableFuture<Double> cf2 =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println(
                  Thread.currentThread() + " start job2,time->" + System.currentTimeMillis());
              try {
                Thread.sleep(1500);
              } catch (InterruptedException e) {
              }
              System.out.println(
                  Thread.currentThread() + " exit job2,time->" + System.currentTimeMillis());
              return 3.2;
            });
    CompletableFuture<Double> cf3 =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println(
                  Thread.currentThread() + " start job3,time->" + System.currentTimeMillis());
              try {
                Thread.sleep(1300);
              } catch (InterruptedException e) {
              }
              //            throw new RuntimeException("test");
              System.out.println(
                  Thread.currentThread() + " exit job3,time->" + System.currentTimeMillis());
              return 2.2;
            });
    // allof等待所有任务执行完成才执行cf4，如果有一个任务异常终止，则cf4.get时会抛出异常，都是正常执行，cf4.get返回null
    // anyOf是只有一个任务执行完成，无论是正常执行或者执行异常，都会执行cf4，cf4.get的结果就是已执行完成的任务的执行结果
    CompletableFuture cf4 =
        CompletableFuture.allOf(cf, cf2, cf3)
            .whenComplete(
                (a, b) -> {
                  if (b != null) {
                    System.out.println("error stack trace->");
                    b.printStackTrace();
                  } else {
                    System.out.println("run succ,result->" + a);
                  }
                });

    System.out.println("main thread start cf4.get(),time->" + System.currentTimeMillis());
    // 等待子任务执行完成
    System.out.println("cf4 run result->" + cf4.get());
    System.out.println("main thread exit,time->" + System.currentTimeMillis());
  }
}
