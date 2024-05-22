package org.oizehsgl.guava.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-guava.properties")
public class GuavaAutoConfiguration {}
