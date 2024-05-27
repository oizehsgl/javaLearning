package org.oizehsgl.jdk8.feature.util;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@Slf4j
@SpringBootTest
public class MapTests {
  @Test
  public void compute() {
    Map<String, String> map = new HashMap<>();
    map.computeIfPresent("key", (k, v) -> "#present:" + k + v);
    log.info("[map<{}>]", map);
    map.compute("key", (k, v) -> "#all:" + k + v);
    log.info("[map<{}>]", map);
    map.computeIfAbsent("key", k -> "#absent:" + k);
    log.info("[map<{}>]", map);
    map.compute("key", (k, v) -> "#all:" + k + v);
    log.info("[map<{}>]", map);
    map.computeIfPresent("key", (k, v) -> "#present:" + k + v);
    log.info("[map<{}>]", map);
  }
}
