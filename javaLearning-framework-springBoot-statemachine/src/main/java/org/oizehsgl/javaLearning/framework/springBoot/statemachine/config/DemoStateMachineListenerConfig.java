package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 订单状态机监听器配置
 *
 * @author yueyuanzhi
 */
@Slf4j
@WithStateMachine
@Configuration
public class DemoStateMachineListenerConfig  {
    @OnTransitionEnd()
    public void create() {
        DemoState.S1.name();
        log.info("订单创建，待支付");
    }
}
