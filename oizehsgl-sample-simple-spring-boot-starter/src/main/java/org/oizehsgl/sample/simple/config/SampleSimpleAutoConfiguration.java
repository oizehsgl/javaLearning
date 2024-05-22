package org.oizehsgl.sample.simple.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-sample-simple.properties")
public class SampleSimpleAutoConfiguration {}
