package org.oizehsgl.starter.demo.service;

import jakarta.annotation.Resource;
import org.oizehsgl.starter.demo.properties.StarterDemoProperties;

/**
 * @author oizehsgl
 */
public class StarterDemoServiceImpl implements StarterDemoService {
    @Resource
    private StarterDemoProperties starterDemoProperties;

    @Override
    public void demo() {
        System.out.println(starterDemoProperties);
    }
}
