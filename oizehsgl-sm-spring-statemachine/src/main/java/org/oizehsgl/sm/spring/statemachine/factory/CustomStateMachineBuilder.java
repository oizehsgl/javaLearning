package org.oizehsgl.sm.spring.statemachine.factory; // package
                                                     // org.oizehsgl.spring.statemachine.factory;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
/// **
// * 状态机建造者
// *
// * @author oizehsgl
// */
// @Slf4j
// @Component
// public class CustomStateMachineBuilder extends StateMachineBuilder {
//
//  @Resource private CustomStateMachineListener customStateMachineListener;
//  @Resource private CustomStateMachineDoAction customStateMachineDoAction;
//  @Resource private CustomStateMachineJudgementGuard customStateMachineJudgementGuard;
//
//  /**
//   * @param beanFactory bean工厂
//   * @return {@link StateMachine }<{@link CustomState }, {@link CustomEvent }>
//   * @throws Exception 异常
//   */
//  public StateMachine<CustomState, CustomEvent> build(BeanFactory beanFactory) throws Exception {
//    Builder<CustomState, CustomEvent> builder = StateMachineBuilder.builder();
//    // 配置
//    builder
//        .configureConfiguration()
//        .withConfiguration()
//        .machineId("machineId")
//        .beanFactory(beanFactory)
//        .autoStartup(true)
//        // 监听器
//        .listener(customStateMachineListener)
//        .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
//        .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
//    // 状态
//    builder
//        .configureStates()
//        .withStates()
//        .initial(CustomState.S1)
//        .end(CustomState.S4)
//        .state(CustomState.S4, customStateMachineDoAction)
//        .state(CustomState.S4, customStateMachineDoAction, customStateMachineDoAction)
//        .states(EnumSet.allOf(CustomState.class));
//    // 转换
//    builder
//        .configureTransitions()
//        // 支付事件: 待支付->待发货
//        .withExternal()
//        .source(CustomState.S1)
//        .event(CustomEvent.E1)
//        .action(customStateMachineDoAction)
//        .target(CustomState.S2)
//        .guard(customStateMachineJudgementGuard)
//        // 发货事件: 待发货->待收货
//        .and()
//        .withExternal()
//        .source(CustomState.S2)
//        .event(CustomEvent.E2)
//        .action(customStateMachineDoAction)
//        .target(CustomState.S3)
//        // 收货事件: 待收货->已完成
//        .and()
//        .withExternal()
//        .source(CustomState.S3)
//        .event(CustomEvent.E3)
//        .action(customStateMachineDoAction)
//        .target(CustomState.S4);
//    return builder.build();
//  }
// }
