package org.oizehsgl.javaLearning.framework.springBoot.gracefulShutdown;

import jakarta.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

/**
 * 注解关机钩子
 *
 * @author oizehsgl
 */
@Component
public class AnnotationShutdownHook {
  @PreDestroy
  public void shutdown() throws InterruptedException {
    System.out.println("preDestroy");
    TimeUnit.SECONDS.sleep(1);
  }
}
