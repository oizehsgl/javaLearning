package org.oizehsgl.javaLearning.framework.springBoot.statemachine.service;

import jakarta.annotation.Resource;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.stereotype.Service;

/**
 * 订单服务层
 *
 * @author yueyuanzhi
 */
@Service
public class DemoService {
    @Resource
    private StateMachineRuntimePersister<DemoState, DemoEvent, String> stateMachineRuntimePersister;

    public void changeState() {
    }
}
