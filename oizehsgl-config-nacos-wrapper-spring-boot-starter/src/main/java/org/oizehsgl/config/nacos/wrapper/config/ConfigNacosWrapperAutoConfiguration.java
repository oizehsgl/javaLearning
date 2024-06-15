package org.oizehsgl.config.nacos.wrapper.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-config-nacos-wrapper.properties")
public class ConfigNacosWrapperAutoConfiguration {}
