package org.oizehsgl.demo.config;

import org.oizehsgl.demo.properties.DemoProperties;
import org.oizehsgl.demo.service.DemoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
}
