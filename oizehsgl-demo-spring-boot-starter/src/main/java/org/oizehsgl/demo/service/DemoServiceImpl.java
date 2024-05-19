package org.oizehsgl.demo.service;

import jakarta.annotation.Resource;
import org.oizehsgl.demo.properties.DemoProperties;

/**
 * @author oizehsgl
 */
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoProperties demoProperties;

    @Override
    public void demo() {
        System.out.println(demoProperties);
    }
}
