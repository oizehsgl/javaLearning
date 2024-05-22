package org.oizehsgl.sample.simple.wrapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sample.simple.manager.SampleSimpleManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OizehsglSampleSimpleWrapperSpringBootStarterApplicationTests {
  @Resource private SampleSimpleManager sampleSimpleManager;

  @Test
  void contextLoads() {
    sampleSimpleManager.fun();
  }
}
