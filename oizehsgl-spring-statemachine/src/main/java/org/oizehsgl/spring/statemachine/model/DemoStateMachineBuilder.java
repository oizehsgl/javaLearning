package org.oizehsgl.spring.statemachine.model;

import jakarta.annotation.Resource;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.DemoEvent;
import org.oizehsgl.spring.statemachine.enums.DemoState;
import org.oizehsgl.spring.statemachine.hook.DemoStateMachineAction;
import org.oizehsgl.spring.statemachine.hook.DemoStateMachineGuard;
import org.oizehsgl.spring.statemachine.hook.DemoStateMachineListener;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.StateDoActionPolicy;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

/**
 * 订单状态机建造者
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class DemoStateMachineBuilder extends StateMachineBuilder {
  private static final String MACHINE_ID = "demoMachine";

  @Resource private DemoStateMachineListener demoStateMachineListener;
  @Resource private DemoStateMachineAction demoStateMachineAction;
  @Resource private DemoStateMachineGuard demoStateMachineGuard;

  /**
   * @param beanFactory bean工厂
   * @return {@link StateMachine }<{@link DemoState }, {@link DemoEvent }>
   * @throws Exception 异常
   */
  public StateMachine<DemoState, DemoEvent> build(BeanFactory beanFactory) throws Exception {
    Builder<DemoState, DemoEvent> builder = StateMachineBuilder.builder();
    // 配置
    builder
        .configureConfiguration()
        .withConfiguration()
        .machineId(MACHINE_ID)
        .beanFactory(beanFactory)
        .autoStartup(true)
        // 监听器
        .listener(demoStateMachineListener)
        .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
        .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS);
    // 状态
    builder
        .configureStates()
        .withStates()
        .initial(DemoState.S1)
        .end(DemoState.S4)
        .state(DemoState.S4, demoStateMachineAction)
        .state(DemoState.S4, demoStateMachineAction, demoStateMachineAction)
        .states(EnumSet.allOf(DemoState.class));
    // 转换
    builder
        .configureTransitions()
        // 支付事件: 待支付->待发货
        .withExternal()
        .source(DemoState.S1)
        .event(DemoEvent.E1)
        .action(demoStateMachineAction)
        .target(DemoState.S2)
        .guard(demoStateMachineGuard)
        // 发货事件: 待发货->待收货
        .and()
        .withExternal()
        .source(DemoState.S2)
        .event(DemoEvent.E2)
        .action(demoStateMachineAction)
        .target(DemoState.S3)
        // 收货事件: 待收货->已完成
        .and()
        .withExternal()
        .source(DemoState.S3)
        .event(DemoEvent.E3)
        .action(demoStateMachineAction)
        .target(DemoState.S4);
    return builder.build();
  }
}
