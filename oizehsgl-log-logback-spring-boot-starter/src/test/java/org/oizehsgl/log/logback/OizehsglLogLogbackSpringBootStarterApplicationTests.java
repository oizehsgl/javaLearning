package org.oizehsgl.log.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class OizehsglLogLogbackSpringBootStarterApplicationTests {

  @Test
  void contextLoads() {
    log.info("log[level<{}>]","info");
  }
}
