package org.oizehsgl.javaLearning.framework.springBoot.env.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class DatabaseEnvironmentPostProcessorTest {

    @Resource
    private Environment environment;

    @Test
    public void test(){
        Assertions.assertEquals(environment.getProperty(DatabaseEnvironmentPostProcessor.TEST_PROPERTY),"1");
    }
}