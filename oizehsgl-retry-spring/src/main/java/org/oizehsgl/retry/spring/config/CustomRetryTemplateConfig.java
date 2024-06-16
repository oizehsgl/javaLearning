package org.oizehsgl.retry.spring.config;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

import java.time.Duration;

/**
 * @author oizehsgl
 */
@Configuration
public class CustomRetryTemplateConfig {
    public static final String CONFIG_CUSTOM_RETRY_TEMPLATE_BEAN_NAME = "configCustomRetryTemplate";
    @Bean(CONFIG_CUSTOM_RETRY_TEMPLATE_BEAN_NAME)
    public RetryTemplate configCustomRetryTemplate() {
        return RetryTemplate.builder()
                .maxAttempts(3)
                .exponentialBackoff(Duration.ofSeconds(2),2,Duration.ofSeconds(8),true)
                .build();
    }
}
