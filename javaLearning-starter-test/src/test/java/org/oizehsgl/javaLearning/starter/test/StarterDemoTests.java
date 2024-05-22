package org.oizehsgl.javaLearning.starter.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.starter.demo.manager.StarterDemoManager;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
public class StarterDemoTests {
  @Resource private StarterDemoManager starterDemoManager;

  @Test
  public void test() {
    starterDemoManager.demo();
  }
}
