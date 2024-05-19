package org.oizehsgl.starter.demo.manager;

import jakarta.annotation.Resource;
import lombok.Builder;
import org.oizehsgl.starter.demo.service.StarterDemoService;

/**
 * @author oizehsgl
 */
@Builder
public class StarterDemoManager {
  @Resource private StarterDemoService starterDemoService;

  public void demo() {
    System.out.println("begin------------------");
    starterDemoService.demo();
    System.out.println("end------------------");
  }
}
