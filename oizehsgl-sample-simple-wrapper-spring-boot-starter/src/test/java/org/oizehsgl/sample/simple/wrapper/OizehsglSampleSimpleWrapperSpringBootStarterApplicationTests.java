package org.oizehsgl.sample.simple.wrapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sample.simple.manager.SampleSimpleManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OizehsglSampleSimpleWrapperSpringBootStarterApplicationTests {
  @Resource
  private SampleSimpleManager sampleSimpleManager;

  @Test
  void contextLoads() {
    sampleSimpleManager.fun();
  }
}
