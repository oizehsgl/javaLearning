package org.oizehsgl.starter.demo.wrapper.config;

import org.oizehsgl.starter.demo.properties.StarterDemoProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-starter-demo-wrapper.properties")
public class StarterDemoWrapperAutoConfiguration {
    @Bean
    public StarterDemoProperties starterDemoProperties() {
        StarterDemoProperties starterDemoProperties = new StarterDemoProperties();
        starterDemoProperties.setCode("2");
        starterDemoProperties.setName("starter-demo-wrapper");
        return starterDemoProperties;
    }
}
