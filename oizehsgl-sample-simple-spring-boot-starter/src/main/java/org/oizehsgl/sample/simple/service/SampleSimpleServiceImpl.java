package org.oizehsgl.sample.simple.service;

import jakarta.annotation.Resource;
import org.oizehsgl.sample.simple.properties.SampleSimpleProperties;

/**
 * @author oizehsgl
 */
public class SampleSimpleServiceImpl implements SampleSimpleService {
  @Resource private SampleSimpleProperties sampleSimpleProperties;

  @Override
  public void fun() {
    System.out.println(sampleSimpleProperties);
  }
}
