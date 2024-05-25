package org.oizehsgl.sm.spring.statemachine.factory;

import jakarta.annotation.Resource;

import java.util.EnumSet;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.hook.action.*;
import org.oizehsgl.sm.spring.statemachine.hook.guard.CustomStateMachineChoiceGuard;
import org.oizehsgl.sm.spring.statemachine.hook.guard.CustomStateMachineJudgementGuard;
import org.oizehsgl.sm.spring.statemachine.hook.guard.CustomStateMachineJunctionGuard;
import org.oizehsgl.sm.spring.statemachine.hook.listener.CustomStateMachineListener;
import org.oizehsgl.sm.spring.statemachine.persist.redis.runtime.CustomRedisPersistingStateMachineInterceptor;
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
  @Resource private CustomStateMachinePseudoAction customStateMachinePseudoAction;
  @Resource private CustomStateMachineTimerAction customStateMachineTimerAction;
  @Resource private CustomStateMachineDoAction customStateMachineDoAction;
  @Resource private CustomStateMachineRestartAction customStateMachineRestartAction;
  @Resource private CustomStateMachineEntryAction customStateMachineEntryAction;
  @Resource private CustomStateMachineExitAction customStateMachineExitAction;
  @Resource private CustomStateMachineJudgementGuard customStateMachineJudgementGuard;
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
        .region("初始区域")
        .initial(CustomState.INITIAL, customStateMachineInitialAction)
        .state(CustomState.R1, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R2, customStateMachineEntryAction, customStateMachineExitAction)
        // .history(CustomState.HISTORY, StateConfigurer.History.SHALLOW)
        .choice(CustomState.CHOICE)
        .junction(CustomState.JUNCTION)
        .fork(CustomState.FORK)
        .join(CustomState.JOIN)
        .end(CustomState.END)
        .and()
        .withStates()
        .region("R1")
        .parent(CustomState.R1)
        .initial(CustomState.R1A, customStateMachineInitialAction)
        .state(CustomState.R1A, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1B, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1C, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1D, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1E, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1F, customStateMachineEntryAction, customStateMachineExitAction)
        .and()
        .withStates()
        .region("R2ABC")
        .parent(CustomState.R2)
        .initial(CustomState.R2A, customStateMachineInitialAction)
        .state(CustomState.R2A, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R2B, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R2C, customStateMachineEntryAction, customStateMachineExitAction)
        .and()
        .withStates()
        .region("R2XYZ")
        .parent(CustomState.R2)
        .initial(CustomState.R2X, customStateMachineInitialAction)
        .state(CustomState.R2X, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R2Y, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R2Z, customStateMachineEntryAction, customStateMachineExitAction);
  }

  public void trans(
      StateMachineTransitionConfigurer<CustomState, CustomEvent> transitions,
      CustomEvent customEvent,
      CustomState... customStates)
      throws Exception {
    // 配置区域转换
    CustomState lastCustomState = null;
    for (CustomState customState : customStates) {
      if (Objects.nonNull(lastCustomState)) {
        transitions
            .withExternal()
            .source(lastCustomState)
            .target(customState)
            .guard(customStateMachineJudgementGuard)
            .action(customStateMachineTransitionAction, customStateMachineErrorAction)
            .event(customEvent);
      }
      lastCustomState = customState;
    }
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
    trans(
        transitions,
        CustomEvent.NEXT,
        CustomState.INITIAL,
        CustomState.R1,
        CustomState.R2,
        CustomState.HISTORY,
        CustomState.CHOICE,
        CustomState.JUNCTION,
        CustomState.FORK,
        CustomState.JOIN,
        CustomState.END);
    // 配置区域转换
    trans(
        transitions,
        CustomEvent.SUB_NEXT,
        CustomState.R1,
        CustomState.R1A,
        CustomState.R1B,
        CustomState.R1C,
        CustomState.R1D,
        CustomState.R1E,
        CustomState.R1F,
        CustomState.R2);
    trans(
        transitions,
        CustomEvent.SUB_NEXT1,
        CustomState.R2,
        CustomState.R2A,
        CustomState.R2B,
        CustomState.R2C,
        CustomState.CHOICE);
    trans(
        transitions,
        CustomEvent.SUB_NEXT2,
        CustomState.R2,
        CustomState.R2X,
        CustomState.R2Y,
        CustomState.R2Z,
        CustomState.CHOICE);
    // 历史
    // transitions.withHistory().source(CustomState.HISTORY).target(CustomState.S1B);
    // 选择
    transitions
        .withChoice()
        .source(CustomState.CHOICE)
        .first(
            CustomState.JUNCTION,
            customStateMachineChoiceGuard,
            customStateMachineTransitionAction,
            customStateMachineErrorAction)
        .then(
            CustomState.FORK,
            customStateMachineChoiceGuard,
            customStateMachineTransitionAction,
            customStateMachineErrorAction)
        .last(CustomState.R1, customStateMachineTransitionAction, customStateMachineErrorAction);
    // 联结
    transitions
        .withJunction()
        .source(CustomState.JUNCTION)
        .first(
            CustomState.FORK,
            customStateMachineJunctionGuard,
            customStateMachineTransitionAction,
            customStateMachineErrorAction)
        .then(
            CustomState.R1,
            customStateMachineJunctionGuard,
            customStateMachineTransitionAction,
            customStateMachineErrorAction)
        .last(CustomState.END, customStateMachineDoAction, customStateMachineErrorAction);
    // 分流
    // TODO: R2Z->R2Y之后,R2Z还会生效
    transitions.withFork().source(CustomState.FORK).target(CustomState.R2B).target(CustomState.R2Y);
    // 合流
    transitions
        .withJoin()
        //.source(CustomState.R2C)
        //.source(CustomState.R2Y)
            .sources(EnumSet.of(CustomState.R2C,CustomState.R2Y))
        .target(CustomState.JOIN)
        .and()
        .withExternal()
        .source(CustomState.JOIN)
        .target(CustomState.END)
            .and()
            .withExternal()
            .source(CustomState.R2Y)
            .target(CustomState.R2Z)
            .event(CustomEvent.SUB_NEXT3)
    ;

    // transitions
    //   // .withEntry().source(CustomState.S1ENTRY).target(CustomState.S4);
    //   .withExternal()
    //   .source(CustomState.S1)
    //   .target(CustomState.S1ENTRY)
    //   .event(CustomEvent.ENTRY)
    //   .and()
    //   .withExternal()
    //   .source(CustomState.S1C)
    //   .target(CustomState.S1EXIT)
    //   .event(CustomEvent.EXIT)
    //   .and()
    //   .withEntry()
    //   .source(CustomState.S1ENTRY)
    //   .target(CustomState.S1D)
    //   .and()
    //   .withExit()
    //   .source(CustomState.S1EXIT)
    //   .target(CustomState.S3);
    // transitions.withExit().source(CustomState.S2EXIT).target(CustomState.S5);
    // 定时器
    // transitions
    //    .withExternal()
    //    .source(CustomState.R1C)
    //    .target(CustomState.R1D)
    //    .action(customStateMachineTimerAction)
    //    .timerOnce(5000);
    //// 配置重启事件
    // for (CustomState customState : EnumSet.allOf(CustomState.class)) {
    //  transitions
    //      .withExternal()
    //      .source(customState)
    //      .event(CustomEvent.RESTART)
    //      .action(customStateMachineRestartAction, customStateMachineErrorAction)
    //      .guard(customStateMachineJudgementGuard)
    //      .target(CustomState.INITIAL);
    // }
  }
}
