package org.oizehsgl.javaLearning.config;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.properties.RedisTestProperties;
import org.oizehsgl.javaLearning.service.DemoService;
import org.oizehsgl.javaLearning.service.impl.DemoServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author oizehsgl
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(value = RedisTestProperties.class)
@RequiredArgsConstructor
public class AutoConfig {
  @Resource private RedisTestProperties redisTestProperties;

  @Bean
  public DemoService demoService() {
    DemoService demoService =
        DemoServiceImpl.builder().redisTestProperties(redisTestProperties).build();
    return demoService;
  }
}
