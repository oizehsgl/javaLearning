package org.oizehsgl.retry.spring.retry;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.retry.spring.config.CustomRetryTemplateConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CustomRetryTemplateTest {
    @Resource(name = CustomRetryTemplateConfig.CONFIG_CUSTOM_RETRY_TEMPLATE_BEAN_NAME)
    private RetryTemplate retryTemplate;

    @Test
    public void test() {
        retryTemplate.execute((ctx) -> {
            System.out.println(ctx);
            return null;
        });
    }
}