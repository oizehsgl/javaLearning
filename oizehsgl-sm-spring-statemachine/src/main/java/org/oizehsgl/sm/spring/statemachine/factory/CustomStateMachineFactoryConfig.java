package org.oizehsgl.sm.spring.statemachine.factory;

import jakarta.annotation.Resource;
import java.util.EnumSet;
import java.util.Objects;
import javax.swing.*;
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
@EnableStateMachineFactory(name = CustomStateMachineFactoryConfig.BEAN_NAME)
public class CustomStateMachineFactoryConfig
    extends EnumStateMachineConfigurerAdapter<CustomState, CustomEvent> {
  public static final String BEAN_NAME = "customStateMachineFactory";

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
    config.withConfiguration().listener(customStateMachineListener)
    //// 额外配置
    // .machineId("machineId")
    // .autoStartup(false)
    // .beanFactory(new StaticListableBeanFactory())
    // .transitionConflictPolicy(TransitionConflictPolicy.CHILD)
    // .regionExecutionPolicy(RegionExecutionPolicy.PARALLEL)
    // .stateDoActionPolicy(StateDoActionPolicy.IMMEDIATE_CANCEL)
    //// 超时策略
    // .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
    // .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS)
    //// TODO: 拦截器持久化有bug,子区无法恢复状态
    // .runtimePersister(customRedisPersistingStateMachineInterceptor)
    ;
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
        .state(CustomState.ENTRY, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.EXIT, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.TIME1, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.TIME2, customStateMachineEntryAction, customStateMachineExitAction)
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
        .entry(CustomState.R1B)
        .state(CustomState.R1C, customStateMachineEntryAction, customStateMachineExitAction)
        .state(CustomState.R1D, customStateMachineEntryAction, customStateMachineExitAction)
        .exit(CustomState.R1E)
        .state(CustomState.R1F, customStateMachineEntryAction, customStateMachineExitAction)
        // TODO: #830 history没有测试成功,在拦截器下会有NPE
        // .state(
        //    CustomState.HISTORY_DEFAULT,
        //    customStateMachineEntryAction,
        //    customStateMachineExitAction)
        // .history(CustomState.HISTORY, StateConfigurer.History.SHALLOW)
        // TODO: #998 #1142 TMD这bug也太多了
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
        .state(CustomState.R2Z, customStateMachineEntryAction, customStateMachineExitAction)
        .stateEntry(CustomState.LOCAL, customStateMachineEntryAction, customStateMachineErrorAction)
        .stateDo(CustomState.LOCAL, customStateMachineDoAction)
        .stateExit(CustomState.LOCAL, customStateMachineExitAction, customStateMachineDoAction);
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
    // 历史
    // transitions.withHistory().source(CustomState.HISTORY).target(CustomState.HISTORY_DEFAULT);
    // 配置启动转换
    trans(
        transitions,
        CustomEvent.NEXT,
        CustomState.INITIAL,
        CustomState.R1,
        CustomState.R2,
        CustomState.ENTRY,
        CustomState.EXIT,
        // CustomState.HISTORY,
        CustomState.CHOICE,
        CustomState.JUNCTION,
        CustomState.FORK,
        CustomState.JOIN,
        CustomState.TIME1,
        CustomState.TIME2);
    transitions
        .withExternal()
        .source(CustomState.R2)
        .target(CustomState.R1)
        .guard(customStateMachineJudgementGuard)
        .action(customStateMachineTransitionAction, customStateMachineErrorAction)
        .event(CustomEvent.LAST);
    // 配置区域转换
    trans(
        transitions,
        CustomEvent.SUB_NEXT,
        CustomState.R1,
        CustomState.R1A,
        CustomState.R1C,
        CustomState.R1D,
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
        .last(CustomState.TIME1, customStateMachineDoAction, customStateMachineErrorAction);
    // 分流
    transitions.withFork().source(CustomState.FORK).target(CustomState.R2B).target(CustomState.R2Y);
    // 合流
    // TODO: join只要触发过状态就可以触发,不代表当前状态必须处于这个状态
    transitions
        .withJoin()
        .sources(EnumSet.of(CustomState.R2C, CustomState.R2Z))
        .target(CustomState.JOIN)
        .and()
        .withExternal()
        .source(CustomState.JOIN)
        .target(CustomState.TIME1)
        .and()
        .withExternal()
        .source(CustomState.R2Y)
        .target(CustomState.R2Z)
        .event(CustomEvent.SUB_NEXT3);
    // 进入
    transitions
        .withExternal()
        .source(CustomState.ENTRY)
        .target(CustomState.R1B)
        .event(CustomEvent.ENTRY)
        .and()
        .withEntry()
        .source(CustomState.R1B)
        .target(CustomState.R1C);
    // 退出
    transitions
        .withExternal()
        .source(CustomState.R1C)
        .target(CustomState.R1E)
        .event(CustomEvent.EXIT)
        .and()
        .withExit()
        .source(CustomState.R1E)
        .target(CustomState.EXIT);
    // 定时器
    transitions
        .withExternal()
        .source(CustomState.TIME1)
        .target(CustomState.TIME2)
        .action(customStateMachineTimerAction)
        .timerOnce(5000);
    transitions
        .withInternal()
        .source(CustomState.TIME1)
        .action(customStateMachineTimerAction)
        .timer(1000);
    transitions
        .withInternal()
        .source(CustomState.TIME2)
        .action(customStateMachineTimerAction)
        .timer(1000);
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
    transitions
        .withExternal()
        .source(CustomState.INITIAL)
        .target(CustomState.LOCAL)
        .event(CustomEvent.LOCAL)
        .and()
        .withInternal()
        .source(CustomState.LOCAL)
        // .target(CustomState.LOCAL)
        .action(
            ctx -> {
              System.out.println("触发LOCAL");
            })
        .event(CustomEvent.LOCAL);
  }
}
