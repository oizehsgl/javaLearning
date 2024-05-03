package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineAction;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineErrorAction;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineGuard;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger.OrderStateMachineListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 订单状态机配置
 *
 * @author yueyuanzhi
 */
@Slf4j
@Configuration
@EnableStateMachineFactory(name = OrderStateMachineFactoryConfig.STATE_MACHINE_FACTORY)
public class OrderStateMachineFactoryConfig extends StateMachineConfigurerAdapter<OrderState, OrderEvent> {
    public final static String STATE_MACHINE_FACTORY = "orderStateMachineFactory";

    @Resource
    private OrderStateMachineListener orderStateMachineListener;
    @Resource
    private OrderStateMachineAction orderStateMachineAction;
    @Resource
    private OrderStateMachineGuard orderStateMachineGuard;
    @Resource
    private OrderStateMachineErrorAction orderStateMachineErrorAction;

    /**
     * 配置
     *
     * @param config 状态机
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderState, OrderEvent> config) throws Exception {
        config.withConfiguration()
                .machineId(STATE_MACHINE_FACTORY)
                //.autoStartup(false)
                // 监听器
                .listener(orderStateMachineListener)
        //.stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
        //.stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
        ;
    }

    /**
     * 状态
     *
     * @param states 状态机
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderState.WAIT_PAYMENT)
                .end(OrderState.WAIT_PAYMENT)
                //.state(OrderState.FINISH, orderStateMachineAction)
                //.state(OrderState.FINISH, orderStateMachineAction, orderStateMachineAction)
                //.stateEntry(OrderState.WAIT_DELIVER, orderStateMachineAction, orderStateMachineErrorAction)
                //.stateDo(OrderState.WAIT_DELIVER, orderStateMachineAction, orderStateMachineErrorAction)
                //.stateExit(OrderState.WAIT_DELIVER, orderStateMachineAction, orderStateMachineErrorAction)
                .states(EnumSet.allOf(OrderState.class));
    }

    /**
     * 转换
     *
     * @param transitions 状态机
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
        transitions
                //支付事件: 待支付->待发货
                .withExternal()
                .source(OrderState.WAIT_PAYMENT)
                .event(OrderEvent.PAYED)
                .action(orderStateMachineAction, orderStateMachineErrorAction)
                .target(OrderState.WAIT_DELIVER)
                .guard(orderStateMachineGuard)
                //发货事件: 待发货->待收货
                .and().withExternal()
                .source(OrderState.WAIT_DELIVER)
                .event(OrderEvent.DELIVERY)
                .action(orderStateMachineAction, orderStateMachineErrorAction)
                .target(OrderState.WAIT_RECEIVE)
                //收货事件: 待收货->已完成
                .and().withExternal()
                .source(OrderState.WAIT_RECEIVE)
                .event(OrderEvent.RECEIVED)
                .action(orderStateMachineAction, orderStateMachineErrorAction)
                .target(OrderState.FINISH);
    }
}
