package org.oizehsgl.redisson.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
public class RedissonAutoConfiguration {
    @PropertySource("classpath:oizehsgl-redisson.properties")
    public static class PropertySourceAutoConfiguration{}
}
