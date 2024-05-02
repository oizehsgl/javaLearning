package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 订单状态机配置
 *
 * @author yueyuanzhi
 */
@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderEvent> {
    /**
     * 配置状态
     *
     * @param stateMachine 状态
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> stateMachine) throws Exception {
        stateMachine.withStates()
                .initial(OrderState.WAIT_PAYMENT)
                .states(EnumSet.allOf(OrderState.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param stateMachine 转换
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> stateMachine) throws Exception {
        stateMachine.withExternal()
                //支付事件: 待支付->待发货
                .source(OrderState.WAIT_PAYMENT).target(OrderState.WAIT_DELIVER).event(OrderEvent.PAYED)
                .and().withExternal()
                //发货事件: 待发货->待收货
                .source(OrderState.WAIT_DELIVER).target(OrderState.WAIT_RECEIVE).event(OrderEvent.DELIVERY)
                .and().withExternal()
                //收货事件: 待收货->已完成
                .source(OrderState.WAIT_RECEIVE).target(OrderState.FINISH).event(OrderEvent.RECEIVED);
    }
}
