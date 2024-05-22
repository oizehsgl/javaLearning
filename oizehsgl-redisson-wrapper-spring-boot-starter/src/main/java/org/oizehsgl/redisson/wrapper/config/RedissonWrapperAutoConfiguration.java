package org.oizehsgl.redisson.wrapper.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-redisson-wrapper.properties")
public class RedissonWrapperAutoConfiguration {}
