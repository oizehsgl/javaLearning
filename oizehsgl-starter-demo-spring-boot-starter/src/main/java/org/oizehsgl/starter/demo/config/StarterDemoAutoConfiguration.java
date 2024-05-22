package org.oizehsgl.starter.demo.config;

import org.oizehsgl.starter.demo.manager.StarterDemoManager;
import org.oizehsgl.starter.demo.properties.StarterDemoProperties;
import org.oizehsgl.starter.demo.service.StarterDemoService;
import org.oizehsgl.starter.demo.service.StarterDemoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-starter-demo.properties")
public class StarterDemoAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(StarterDemoManager.class)
  public StarterDemoManager starterDemoManager(StarterDemoService starterDemoService) {
    return StarterDemoManager.builder().starterDemoService(starterDemoService).build();
  }

  @EnableConfigurationProperties(StarterDemoProperties.class)
  public static class DemoPropertiesConfiguration {}

  @Import({StarterDemoServiceImpl.class})
  public static class demoServiceConfiguration {}
}