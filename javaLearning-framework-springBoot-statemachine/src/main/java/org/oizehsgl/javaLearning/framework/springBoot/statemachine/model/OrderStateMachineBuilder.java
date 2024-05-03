package org.oizehsgl.javaLearning.framework.springBoot.statemachine.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineAction;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineGuard;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineListener;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.StateDoActionPolicy;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/**
 * 订单状态机建造者
 *
 * @author yueyuanzhi
 */
@Slf4j
@Component
public class OrderStateMachineBuilder extends StateMachineBuilder {
    private final static String MACHINE_ID = "orderMachine";

    @Resource
    private OrderStateMachineListener orderStateMachineListener;
    @Resource
    private OrderStateMachineAction orderStateMachineAction;
    @Resource
    private OrderStateMachineGuard orderStateMachineGuard;

    /**
     * @param beanFactory bean工厂
     * @return {@link StateMachine }<{@link OrderState }, {@link OrderEvent }>
     * @throws Exception 异常
     */
    public StateMachine<OrderState, OrderEvent> build(BeanFactory beanFactory) throws Exception {
        StateMachineBuilder.Builder<OrderState, OrderEvent> builder = StateMachineBuilder.builder();
        // 配置
        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINE_ID)
                .beanFactory(beanFactory)
                .autoStartup(true)
                // 监听器
                .listener(orderStateMachineListener)
                .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
                .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
        // 状态
        builder.configureStates()
                .withStates()
                .initial(OrderState.WAIT_PAYMENT)
                .end(OrderState.FINISH)
                .state(OrderState.FINISH, orderStateMachineAction)
                .state(OrderState.FINISH, orderStateMachineAction, orderStateMachineAction)
                .states(EnumSet.allOf(OrderState.class));
        // 转换
        builder.configureTransitions()
                //支付事件: 待支付->待发货
                .withExternal()
                .source(OrderState.WAIT_PAYMENT).event(OrderEvent.PAYED)
                .action(orderStateMachineAction).target(OrderState.WAIT_DELIVER)
                .guard(orderStateMachineGuard)
                //发货事件: 待发货->待收货
                .and().withExternal().source(OrderState.WAIT_DELIVER)
                .event(OrderEvent.DELIVERY).action(orderStateMachineAction).target(OrderState.WAIT_RECEIVE)
                //收货事件: 待收货->已完成
                .and().withExternal().source(OrderState.WAIT_RECEIVE)
                .event(OrderEvent.RECEIVED).action(orderStateMachineAction).target(OrderState.FINISH);
        return builder.build();
    }
}