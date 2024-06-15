package org.oizehsgl.distributed.redisson.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-distributed-redisson.properties")
public class DistributedRedissonAutoConfiguration {}
