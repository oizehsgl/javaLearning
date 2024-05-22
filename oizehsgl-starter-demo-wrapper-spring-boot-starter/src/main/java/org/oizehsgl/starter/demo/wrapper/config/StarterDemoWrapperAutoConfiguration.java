package org.oizehsgl.starter.demo.wrapper.config;

import org.oizehsgl.starter.demo.properties.StarterDemoProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author oizehsgl
 */
@AutoConfiguration
public class StarterDemoWrapperAutoConfiguration {
  @Bean
  public StarterDemoProperties starterDemoProperties() {
    StarterDemoProperties starterDemoProperties = new StarterDemoProperties();
    starterDemoProperties.setCode("2");
    starterDemoProperties.setName("starter-demo-wrapper");
    return starterDemoProperties;
  }
}
