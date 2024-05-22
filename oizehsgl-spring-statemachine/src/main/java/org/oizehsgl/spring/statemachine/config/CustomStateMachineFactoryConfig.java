package org.oizehsgl.spring.statemachine.config;

import jakarta.annotation.Resource;
import java.util.EnumSet;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.hook.CustomStateMachineAction;
import org.oizehsgl.spring.statemachine.hook.CustomStateMachineErrorAction;
import org.oizehsgl.spring.statemachine.hook.CustomStateMachineGuard;
import org.oizehsgl.spring.statemachine.hook.CustomStateMachineListener;
import org.oizehsgl.spring.statemachine.persist.redis.runtime.CustomRedisPersistingStateMachineInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

/**
 * 状态机工厂
 *
 * @author oizehsgl
 */
@Slf4j
@Configuration
@EnableStateMachineFactory(name = CustomStateMachineFactoryConfig.FACTORY_NAME)
public class CustomStateMachineFactoryConfig
    extends EnumStateMachineConfigurerAdapter<CustomState, CustomEvent> {
  public static final String FACTORY_NAME = "customStateMachineFactory";

  @Resource private CustomStateMachineListener customStateMachineListener;
  @Resource private CustomStateMachineAction customStateMachineAction;
  @Resource private CustomStateMachineGuard customStateMachineGuard;
  @Resource private CustomStateMachineErrorAction customStateMachineErrorAction;
  @Resource private CustomRedisPersistingStateMachineInterceptor customRedisPersistingStateMachineInterceptor;

  /**
   * 配置
   *
   * @param config 状态机
   * @throws Exception 异常
   */
  @Override
  public void configure(StateMachineConfigurationConfigurer<CustomState, CustomEvent> config)
      throws Exception {
    config
        .withConfiguration()
        // 机器标识
        //.machineId("machineId")
        // 自动启动
        // .autoStartup(true)
        // 监听器
        .listener(customStateMachineListener)
        .and()
        .withPersistence()
        .runtimePersister(customRedisPersistingStateMachineInterceptor);
    // .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
    // .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
  }

  /**
   * 状态
   *
   * @param states 状态机
   * @throws Exception 异常
   */
  @Override
  public void configure(StateMachineStateConfigurer<CustomState, CustomEvent> states) throws Exception {
    states
        .withStates()
        // 初态(有且只有一个)
        .initial(CustomState.S1, customStateMachineAction)
        // 选择态
        .choice(CustomState.S5)
        // .end(CustomState.WAIT_DELIVER)
        // 单个状态
        // .state(CustomState.S3,demoStateMachineAction)
        // .state(CustomState.S3,demoStateMachineAction,demoStateMachineErrorAction)
        // .stateEntry(CustomState.S3,demoStateMachineAction,demoStateMachineErrorAction)
        // .state(CustomState.FINISH, demoStateMachineAction)
        // .state(CustomState.FINISH, demoStateMachineAction, demoStateMachineAction)
        // .stateEntry(CustomState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
        // .stateDo(CustomState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
        // .stateExit(CustomState.WAIT_DELIVER, demoStateMachineAction, demoStateMachineErrorAction)
        // 多个状态
        // .states(EnumSet.allOf(CustomState.class));
        .states(
            EnumSet.of(
                CustomState.S1,
                CustomState.S2,
                CustomState.S3,
                CustomState.S4,
                CustomState.S5,
                CustomState.S6,
                CustomState.S7,
                CustomState.S8));
  }

  /**
   * 转换
   *
   * @param transitions 状态机
   * @throws Exception 异常
   */
  @Override
  public void configure(StateMachineTransitionConfigurer<CustomState, CustomEvent> transitions)
      throws Exception {
    transitions
        // S1 E1 S2
        .withExternal()
        // 现态
        .source(CustomState.S1)
        // 次态
        .target(CustomState.S2)
        // 事件
        .event(CustomEvent.E1)
        // 动作
        .action(customStateMachineAction, customStateMachineErrorAction)
        // 守卫
        .guard(customStateMachineGuard)
        // S2 E2 S3
        .and()
        .withExternal()
        .source(CustomState.S2)
        .target(CustomState.S3)
        .event(CustomEvent.E2)
        .action(customStateMachineAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        // S3 E3 S4
        .and()
        .withExternal()
        .source(CustomState.S3)
        .event(CustomEvent.E3)
        .action(customStateMachineAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S4)
        .and()
        .withExternal()
        .source(CustomState.S4)
        .event(CustomEvent.E4)
        .action(customStateMachineAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S5)
        .and()
        .withChoice()
        .source(CustomState.S5)
        .first(
            CustomState.S6,
                customStateMachineGuard,
                customStateMachineAction,
                customStateMachineErrorAction)
        .last(CustomState.S7);
  }
}
