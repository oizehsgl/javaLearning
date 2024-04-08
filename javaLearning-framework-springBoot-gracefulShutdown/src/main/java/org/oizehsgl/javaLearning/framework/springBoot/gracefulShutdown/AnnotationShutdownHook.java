package org.oizehsgl.javaLearning.framework.springBoot.gracefulShutdown;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 注解关机钩子
 *
 * @author yueyuanzhi
 */
@Component
public class AnnotationShutdownHook {
    @PreDestroy
    public void shutdown() throws InterruptedException {
        System.out.println("preDestroy");
        TimeUnit.SECONDS.sleep(1);
    }
}
