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
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
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
@EnableStateMachineFactory(name = DemoStateMachineFactoryConfig.LABEL)
public class DemoStateMachineFactoryConfig extends EnumStateMachineConfigurerAdapter<DemoState, DemoEvent> {
    public final static String LABEL = "demoStateMachineFactory";

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
                // 机器标识
                .machineId(LABEL)
                // 自动启动
                //.autoStartup(true)
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
                // 初态(有且只有一个)
                .initial(DemoState.S1,demoStateMachineAction)
                // 选择态
                .choice(DemoState.S5)
                //.end(DemoState.WAIT_DELIVER)
                // 单个状态
                //.state(DemoState.S3,demoStateMachineAction)
                //.state(DemoState.S3,demoStateMachineAction,demoStateMachineErrorAction)
                //.stateEntry(DemoState.S3,demoStateMachineAction,demoStateMachineErrorAction)
                //.state(DemoState.FINISH, demoStateMachineAction)
                //.state(DemoState.FINISH, demoStateMachineAction, demoStateMachineAction)
                //.stateEntry(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                //.stateDo(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                //.stateExit(DemoState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
                // 多个状态
                //.states(EnumSet.allOf(DemoState.class));
                .states(EnumSet.of(DemoState.S1, DemoState.S2, DemoState.S3, DemoState.S4, DemoState.S5, DemoState.S6, DemoState.S7, DemoState.S8));
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
                //S1 E1 S2
                .withExternal()
                // 现态
                .source(DemoState.S1)
                // 次态
                .target(DemoState.S2)
                // 事件
                .event(DemoEvent.E1)
                // 动作
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                // 守卫
                .guard(demoStateMachineGuard)
                //S2 E2 S3
                .and().withExternal()
                .source(DemoState.S2)
                .target(DemoState.S3)
                .event(DemoEvent.E2)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .guard(demoStateMachineGuard)
                //S3 E3 S4
                .and().withExternal()
                .source(DemoState.S3)
                .event(DemoEvent.E3)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .guard(demoStateMachineGuard)
                .target(DemoState.S4)
                .and().withExternal()
                .source(DemoState.S4)
                .event(DemoEvent.E4)
                .action(demoStateMachineAction, demoStateMachineErrorAction)
                .guard(demoStateMachineGuard)
                .target(DemoState.S5)
                .and().withChoice()
                .source(DemoState.S5)
                .first(DemoState.S6, demoStateMachineGuard,demoStateMachineAction,demoStateMachineErrorAction)
                .last(DemoState.S7)

        ;
    }
}
