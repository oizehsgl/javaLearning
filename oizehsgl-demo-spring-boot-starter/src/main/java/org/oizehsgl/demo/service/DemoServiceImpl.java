package org.oizehsgl.demo.service;

import jakarta.annotation.Resource;
import lombok.*;
import org.oizehsgl.demo.properties.DemoProperties;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoProperties demoProperties;

    @Override
    public void demo() {
        System.out.println(demoProperties);
    }
}
