package org.oizehsgl.datasource.dynamic.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoServiceImplTest {
  @Resource private DemoService demoService;

  @Test
  public void test() {
    System.out.println(demoService.list());
  }
}
