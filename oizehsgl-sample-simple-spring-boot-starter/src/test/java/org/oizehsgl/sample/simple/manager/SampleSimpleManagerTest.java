package org.oizehsgl.sample.simple.manager;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class SampleSimpleManagerTest {
  @Resource private SampleSimpleManager sampleSimpleManager;

  @Test
  void fun() {
    sampleSimpleManager.fun();
  }
}
