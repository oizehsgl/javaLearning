package org.oizehsgl.javaLearning.framework.springBoot.restart.controller;

import jakarta.annotation.Resource;
import org.oizehsgl.javaLearning.framework.springBoot.restart.JavaLearningFrameworkSpringBootRestartApplication;
import org.oizehsgl.javaLearning.framework.springBoot.restart.service.RestartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 重启控制层
 *
 * @author oizehsgl
 */
@RestController
public class RestartController {

    @Resource
    private RestartService restartService;

    @GetMapping("/restart/endpoint")
    public void restartByEndpoint() {
        restartService.restartApp();
    }

    /**
     * 貌似有问题
     */
    @GetMapping("/restart/daemon")
    public void restartByDaemon() {
        JavaLearningFrameworkSpringBootRestartApplication.restart();
    }

}
