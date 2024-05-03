package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 订单状态机监听器配置
 *
 * @author yueyuanzhi
 */
@Slf4j
@WithStateMachine
public class OrderStateMachineListenerConfig {
    @OnTransition(target = "")
    public void create() {
        log.info("订单创建，待支付");
    }
}
