package org.oizehsgl.demo.manager;

import jakarta.annotation.Resource;
import lombok.Builder;
import org.oizehsgl.demo.service.DemoService;

/**
 * @author oizehsgl
 */
@Builder
public class DemoManager {
    @Resource
    private DemoService demoService;

    public void demo() {
        System.out.println("begin------------------");
        demoService.demo();
        System.out.println("end------------------");
    }
}
