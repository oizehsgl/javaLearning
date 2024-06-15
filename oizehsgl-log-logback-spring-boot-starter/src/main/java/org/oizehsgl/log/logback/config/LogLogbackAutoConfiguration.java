package org.oizehsgl.log.logback.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-log-logback.properties")
public class LogLogbackAutoConfiguration {}
