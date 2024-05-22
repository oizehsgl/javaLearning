package org.oizehsgl.redis.wrapper.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-redis-wrapper.properties")
public class RedisWrapperAutoConfiguration {}
