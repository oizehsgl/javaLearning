package org.oizehsgl.springBoot.shutdown;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class ApplicationInitializing implements InitializingBean {
  @Getter private static String IP;

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("initializing");
    IP = "";
  }
}
