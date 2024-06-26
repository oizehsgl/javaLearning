package org.oizehsgl.springBoot.properties.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DatabaseEnvironmentPostProcessorTest {

  @Resource private Environment environment;

  @Test
  public void test() {
    Assertions.assertEquals(
        environment.getProperty(DatabaseEnvironmentPostProcessor.TEST_PROPERTY), "1");
  }
}
