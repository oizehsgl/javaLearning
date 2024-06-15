package org.oizehsgl.springBoot.shutdown;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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
    TimeUnit.SECONDS.sleep(3);
  }
}
