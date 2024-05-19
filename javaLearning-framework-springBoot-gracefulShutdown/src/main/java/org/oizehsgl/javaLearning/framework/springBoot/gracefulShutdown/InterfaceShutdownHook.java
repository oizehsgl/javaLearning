package org.oizehsgl.javaLearning.framework.springBoot.gracefulShutdown;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * 接口关机钩子
 *
 * @author oizehsgl
 */
@Component
public class InterfaceShutdownHook implements DisposableBean {
  @Override
  public void destroy() throws Exception {
    System.out.println("disposableBean");
    TimeUnit.SECONDS.sleep(1);
  }
}
