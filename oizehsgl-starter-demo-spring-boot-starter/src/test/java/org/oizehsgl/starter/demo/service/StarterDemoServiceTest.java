package org.oizehsgl.starter.demo.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class StarterDemoServiceTest {
  @Resource private StarterDemoService starterDemoService;

  @Test
  void demo() {
    starterDemoService.demo();
  }
}
