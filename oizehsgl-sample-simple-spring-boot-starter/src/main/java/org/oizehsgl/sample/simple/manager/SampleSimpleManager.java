package org.oizehsgl.sample.simple.manager;

import jakarta.annotation.Resource;
import lombok.Builder;
import org.oizehsgl.sample.simple.service.SampleSimpleService;

/**
 * @author oizehsgl
 */
@Builder
public class SampleSimpleManager {
  @Resource private SampleSimpleService starterDemoService;

  public void fun() {
    System.out.println("begin------------------");
    starterDemoService.fun();
    System.out.println("end------------------");
  }
}
