package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook.DemoStateMachineAction;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook.DemoStateMachineErrorAction;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook.DemoStateMachineGuard;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook.DemoStateMachineListener;
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
@EnableStateMachineFactory(name = DemoStateMachineFactoryConfig.STATE_MACHINE_FACTORY)
public class DemoStateMachineFactoryConfig extends StateMachineConfigurerAdapter<DemoState, DemoEvent> {
    public final static String STATE_MACHINE_FACTORY = "demoStateMachineFactory";

    @Resource
    private DemoStateMachineListener demoStateMachineListener;
    @Resource
    private DemoStateMachineAction demoStateMachineAction;
    @Resource
    private DemoStateMachineGuard demoStateMachineGuard;
    @Resource
    private DemoStateMachineErrorAction demoStateMachineErrorAction;

    /**
     * 配置
     *
     * @param config 状态机
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<DemoState, DemoEvent> config) throws Exception {
        config.withConfiguration()
                .machineId(STATE_MACHINE_FACTORY)
                //.autoStartup(false)
                // 监听器
                .listener(demoStateMachineListener)
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
    public void configure(StateMachineStateConfigurer<DemoState, DemoEvent> states) throws Exception {
        states.withStates()
                .initial(DemoState.S1)
                //.end(DemoState.WAIT_DELIVER)
                //.state(DemoState.FINISH, demoStateMachineAction)
                //.state(DemoState.FINISH, demoStateMachineAction, demoStateMachineAction)
                //.stateEntry(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                //.stateDo(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                //.stateExit(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                .states(EnumSet.allOf(DemoState.class));
    }

    /**
     * 转换
     *
     * @param transitions 状态机
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<DemoState, DemoEvent> transitions) throws Exception {
        transitions
                //支付事件: 待支付->待发货
                .withExternal()
                .source(DemoState.S1)
                .event(DemoEvent.E1)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .target(DemoState.S2)
                .guard(demoStateMachineGuard)
                //发货事件: 待发货->待收货
                .and().withExternal()
                .source(DemoState.S2)
                .event(DemoEvent.E2)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .target(DemoState.S3)
                //收货事件: 待收货->已完成
                .and().withExternal()
                .source(DemoState.S3)
                .event(DemoEvent.E3)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .target(DemoState.S4);
    }
}
