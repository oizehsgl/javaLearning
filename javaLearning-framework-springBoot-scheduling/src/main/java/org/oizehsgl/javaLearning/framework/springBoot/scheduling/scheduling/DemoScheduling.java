package org.oizehsgl.javaLearning.framework.springBoot.scheduling.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 示例调度
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class DemoScheduling {

  @Scheduled(cron = "*/1 * * * * ?")
  public void test1() {
    System.out.println("test cron1");
    log.warn("1");
  }

  @Scheduled(cron = "*/1 * * * * ?")
  public void test2() {
    System.out.println("test cron2");
    log.warn("2");
  }

  @Scheduled(cron = "*/1 * * * * ?")
  public void test3() {
    System.out.println("test cron3");
    log.warn("3");
  }
}
