package org.oizehsgl.spring.statemachine.factory;

import jakarta.annotation.Resource;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.hook.action.*;
import org.oizehsgl.spring.statemachine.hook.guard.CustomStateMachineChoiceGuard;
import org.oizehsgl.spring.statemachine.hook.guard.CustomStateMachineGuard;
import org.oizehsgl.spring.statemachine.hook.guard.CustomStateMachineJunctionGuard;
import org.oizehsgl.spring.statemachine.hook.listener.CustomStateMachineListener;
import org.oizehsgl.spring.statemachine.persist.redis.runtime.CustomRedisPersistingStateMachineInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.StateDoActionPolicy;
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
  @Resource private CustomStateMachineInitialAction customStateMachineInitialAction;
  @Resource private CustomStateMachineAction customStateMachineAction;
  @Resource private CustomStateMachineTimerAction customStateMachineTimerAction;
  @Resource private CustomStateMachineDoAction customStateMachineDoAction;
  @Resource private CustomStateMachineEntryAction customStateMachineEntryAction;
  @Resource private CustomStateMachineExitAction customStateMachineExitAction;
  @Resource private CustomStateMachineGuard customStateMachineGuard;
  @Resource private CustomStateMachineChoiceGuard customStateMachineChoiceGuard;
  @Resource private CustomStateMachineJunctionGuard customStateMachineJunctionGuard;
  @Resource private CustomStateMachineErrorAction customStateMachineErrorAction;

  @Resource
  private CustomRedisPersistingStateMachineInterceptor customRedisPersistingStateMachineInterceptor;

  @Autowired private CustomStateMachineTransitionAction customStateMachineTransitionAction;

  /**
   * 配置
   *
   * @param config 状态机
   * @throws Exception 异常
   */
  @Override
  public void configure(StateMachineConfigurationConfigurer<CustomState, CustomEvent> config)
      throws Exception {
    // config.withConfiguration().machineId("machineId");
    // config.withConfiguration().autoStartup(true);
    // config.withConfiguration().beanFactory(new StaticListableBeanFactory());
    // config.withConfiguration().transitionConflictPolicy(TransitionConflictPolicy.CHILD);
    // config.withConfiguration().regionExecutionPolicy(RegionExecutionPolicy.PARALLEL);
    // config.withConfiguration().stateDoActionPolicy(StateDoActionPolicy.IMMEDIATE_CANCEL);
    // 超时策略
    config.withConfiguration().stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL);
    config.withConfiguration().stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
    config.withConfiguration().listener(customStateMachineListener);
    config.withPersistence().runtimePersister(customRedisPersistingStateMachineInterceptor);
  }

  /**
   * 状态
   *
   * @param states 状态机
   * @throws Exception 异常
   */
  @Override
  public void configure(StateMachineStateConfigurer<CustomState, CustomEvent> states)
      throws Exception {
    states
        .withStates()
        .region("R")
        .initial(CustomState.INITIAL, customStateMachineInitialAction)
        .state(CustomState.S1, customStateMachineAction, customStateMachineAction)
        .stateEntry(CustomState.S1, customStateMachineEntryAction, customStateMachineErrorAction)
        .stateDo(CustomState.S1, customStateMachineDoAction, customStateMachineErrorAction)
        .stateExit(CustomState.S1, customStateMachineExitAction, customStateMachineErrorAction)
        .stateDo(CustomState.S2, customStateMachineDoAction, null)
        .stateDo(CustomState.S3, customStateMachineDoAction, customStateMachineErrorAction)
        .stateEntry(CustomState.S4, customStateMachineEntryAction, customStateMachineErrorAction)
        .stateDo(CustomState.S4, customStateMachineDoAction, customStateMachineErrorAction)
        .stateExit(CustomState.S4, customStateMachineExitAction, customStateMachineErrorAction)
        .stateDo(CustomState.S5, customStateMachineDoAction, customStateMachineErrorAction)
        .stateDo(CustomState.S6, customStateMachineDoAction, customStateMachineErrorAction)
        .state(CustomState.S7, customStateMachineEntryAction, customStateMachineExitAction)
        .stateEntry(CustomState.S8, customStateMachineEntryAction, customStateMachineErrorAction)
        .stateExit(CustomState.S9, customStateMachineExitAction, customStateMachineErrorAction)
        // .history(CustomState.HISTORY, StateConfigurer.History.SHALLOW)
        .choice(CustomState.CHOICE)
        .junction(CustomState.JUNCTION)
        .fork(CustomState.FORK)
        .join(CustomState.JOIN)
        .end(CustomState.END);
    states
        .withStates()
        .region("R1")
        .parent(CustomState.S1)
        .initial(CustomState.S1A)
        .stateDo(CustomState.S1B, customStateMachineDoAction, customStateMachineErrorAction)
        .stateDo(CustomState.S1C, customStateMachineDoAction, customStateMachineErrorAction)
        .entry(CustomState.S1ENTRY)
        .exit(CustomState.S1EXIT)
        .end(CustomState.S1D);
    states
        .withStates()
        .region("R2")
        .parent(CustomState.S2)
        .initial(CustomState.S2A)
        .stateDo(CustomState.S2B, customStateMachineDoAction, customStateMachineErrorAction)
        .stateDo(CustomState.S2C, customStateMachineDoAction, customStateMachineErrorAction)
        .entry(CustomState.S2ENTRY)
        .exit(CustomState.S2EXIT)
        .end(CustomState.S2D);
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
    // 配置启动转换
    transitions
        .withExternal()
        .source(CustomState.INITIAL)
        .event(CustomEvent.E1)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S1);
    transitions
        .withExternal()
        .source(CustomState.S1)
        .event(CustomEvent.E2)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S2);
    transitions
        .withExternal()
        .source(CustomState.S2)
        .event(CustomEvent.E3)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S3);
    transitions
        .withExternal()
        .source(CustomState.S3)
        .event(CustomEvent.E4)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S4);
    transitions
        .withExternal()
        .source(CustomState.S4)
        .event(CustomEvent.E5)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .guard(customStateMachineGuard)
        .target(CustomState.S5);
    // 定时器
    transitions
        .withInternal()
        .source(CustomState.S1)
        .action(customStateMachineTimerAction)
        .timerOnce(5000);
    // 选择
    transitions
        .withChoice()
        .source(CustomState.CHOICE)
        .first(
            CustomState.S1,
            customStateMachineChoiceGuard,
            customStateMachineDoAction,
            customStateMachineErrorAction)
        .then(
            CustomState.S2,
            customStateMachineChoiceGuard,
            customStateMachineDoAction,
            customStateMachineErrorAction)
        .last(CustomState.S3, customStateMachineDoAction, customStateMachineErrorAction);
    // 联结
    transitions
        .withJunction()
        .source(CustomState.JUNCTION)
        .first(
            CustomState.S1,
            customStateMachineJunctionGuard,
            customStateMachineDoAction,
            customStateMachineErrorAction)
        .then(
            CustomState.S2,
            customStateMachineJunctionGuard,
            customStateMachineDoAction,
            customStateMachineErrorAction)
        .last(CustomState.S3, customStateMachineDoAction, customStateMachineErrorAction);
    // 历史
    // transitions.withHistory().source(CustomState.HISTORY).target(CustomState.S1B);
    // 分流
    transitions.withFork().source(CustomState.FORK).target(CustomState.S1B).target(CustomState.S2B);
    // 合流
    transitions
        .withJoin()
        .target(CustomState.JOIN)
        .source(CustomState.S1C)
        .source(CustomState.S2C)
        .and()
        .withExternal()
        .source(CustomState.JOIN)
        .target(CustomState.S3);
    transitions.withEntry().source(CustomState.S1ENTRY).target(CustomState.S4);
    transitions.withExit().source(CustomState.S2EXIT).target(CustomState.S5);
    // 配置重启事件
    for (CustomState customState : EnumSet.allOf(CustomState.class)) {
      transitions
          .withExternal()
          .source(customState)
          .event(CustomEvent.RESTART)
          .action(customStateMachineDoAction, customStateMachineErrorAction)
          .guard(customStateMachineGuard)
          .target(CustomState.INITIAL);
    }
  }
}
