package org.oizehsgl.redisson.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-redisson.properties")
public class RedissonAutoConfiguration {}
