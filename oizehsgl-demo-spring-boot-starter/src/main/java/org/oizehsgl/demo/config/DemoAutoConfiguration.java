package org.oizehsgl.demo.config;

import org.oizehsgl.demo.manager.DemoManager;
import org.oizehsgl.demo.properties.DemoProperties;
import org.oizehsgl.demo.service.DemoService;
import org.oizehsgl.demo.service.DemoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author oizehsgl
 */
@AutoConfiguration
public class DemoAutoConfiguration {

    @Configuration
    @EnableConfigurationProperties(DemoProperties.class)
    public static class DemoPropertiesConfiguration{}

    @Configuration
    @Import({DemoServiceImpl.class})
    public static class demoServiceConfiguration {}

    @Bean
    @ConditionalOnMissingBean(DemoManager.class)
    public DemoManager demoManager(DemoService demoService) {
        return DemoManager.builder().demoService(demoService).build();
    }
}
