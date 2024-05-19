package org.oizehsgl.javaLearning.service.impl;

import jakarta.annotation.Resource;
import lombok.Builder;
import org.oizehsgl.javaLearning.properties.RedisTestProperties;
import org.oizehsgl.javaLearning.service.DemoService;

/**
 * @author oizehsgl
 */
@Builder
// @Service
public class DemoServiceImpl implements DemoService {
  @Resource private RedisTestProperties redisTestProperties;

  @Override
  public void demo() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println(redisTestProperties.getTestA());
    System.out.println("-----------------------------------------------------------------------");
  }
}
