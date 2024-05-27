package org.oizehsgl.executor.affinity;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
// @SpringBootTest
@Slf4j
class CompletableFutureChainsKeyAffinityExecutorTest {

  @Test
  void execute() throws InterruptedException {
    Map<String, String> map = new HashMap<>();
    for (int i = 0;
        i < 1_000_000;
        i += ((Double) Math.pow(10, String.valueOf(i).length() - 1)).intValue()) {
      int finalI = i;
      CompletableFutureChainsKeyAffinityExecutor.execute(
          String.valueOf(String.valueOf(finalI).length()),
          () -> {
            try {
              TimeUnit.MILLISECONDS.sleep(10);
              log.info(
                  "有序并行[<{}>,<{}>,<{}>]",
                  LocalTime.now(),
                  finalI,
                  Thread.currentThread().getName());
              map.put(LocalTime.now().toString(), String.valueOf(finalI));
            } catch (InterruptedException e) {
              log.error("执行异常[error<{}>]", e.getMessage(), e);
            }
          });
    }
    // map.Entry.comparingByKey()
    // map.entrySet().stream()
    //    .sorted(Collections.or(Map.Entry.comparingByValue()))
    //    .forEach(System.out::println);
    TimeUnit.SECONDS.sleep(11);
    map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
  }
}
