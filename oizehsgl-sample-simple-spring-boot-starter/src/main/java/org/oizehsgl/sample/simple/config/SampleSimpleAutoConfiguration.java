package org.oizehsgl.sample.simple.config;

import org.oizehsgl.sample.simple.manager.SampleSimpleManager;
import org.oizehsgl.sample.simple.properties.SampleSimpleProperties;
import org.oizehsgl.sample.simple.service.SampleSimpleService;
import org.oizehsgl.sample.simple.service.SampleSimpleServiceImpl;
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
@PropertySource("classpath:oizehsgl-sample-simple.properties")
public class SampleSimpleAutoConfiguration {

  @Import({SampleSimpleServiceImpl.class})
  public static class SampleSimpleServiceAutoConfiguration {}

  @Bean
  @ConditionalOnMissingBean(SampleSimpleManager.class)
  public SampleSimpleManager sampleSimpleManager(SampleSimpleService sampleSimpleService) {
    return SampleSimpleManager.builder().starterDemoService(sampleSimpleService).build();
  }

  @EnableConfigurationProperties(SampleSimpleProperties.class)
  public static class SampleSimplePropertiesAutoConfiguration {}
}
