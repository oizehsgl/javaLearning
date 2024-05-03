package org.oizehsgl.javaLearning.framework.springBoot.statemachine.service;

import jakarta.annotation.Resource;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.stereotype.Service;

/**
 * 订单服务层
 *
 * @author yueyuanzhi
 */
@Service
public class OrderService {
    @Resource
    private StateMachineRuntimePersister<OrderState, OrderEvent, String> stateMachineRuntimePersister;

    public void changeState() {
    }
}
