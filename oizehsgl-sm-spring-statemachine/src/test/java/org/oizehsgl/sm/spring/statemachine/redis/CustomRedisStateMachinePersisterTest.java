package org.oizehsgl.sm.spring.statemachine.redis;

import jakarta.annotation.Resource;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineFactoryConfig;
import org.oizehsgl.sm.spring.statemachine.persist.redis.CustomRedisStateMachinePersister;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachineMessageHeaders;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@Slf4j
@SpringBootTest
class CustomRedisStateMachinePersisterTest {

  @Resource private CustomRedisStateMachinePersister customRedisStateMachinePersister;

  @Resource
  private CustomRedisTemplate<StateMachineContext<CustomState, CustomEvent>> customRedisTemplate;

  public void clear(String machineId) {
    // stateMachineFactory.getStateMachine(machineId);
    // stateMachinePersist.write(, machineId);
    // String key ="FSM:" + machineId+"*";
    String key = "*";
    Set<String> keySet = customRedisTemplate.keys(key);
    customRedisTemplate.delete(keySet);
  }

  @Resource(name = CustomStateMachineFactoryConfig.FACTORY_NAME)
  private StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;

  @Test
  void test() throws Exception {
    // clear("");
    // StateMachine<CustomState, CustomEvent> stateMachine =
    //    stateMachineFactory.getStateMachine("2048");
    // stateMachine.startReactively().subscribe();
    send(CustomEvent.NEXT);
    send(CustomEvent.NEXT);
    send(CustomEvent.NEXT);
    send(CustomEvent.ENTRY);
    send(CustomEvent.EXIT);
    send(CustomEvent.NEXT);
    send(CustomEvent.LAST);
    send(CustomEvent.NEXT);
    send(CustomEvent.SUB_NEXT1);
    send(CustomEvent.SUB_NEXT1);
    send(CustomEvent.SUB_NEXT2);
    send(CustomEvent.SUB_NEXT2);

    // send(stateMachine, CustomEvent.SUB_NEXT2);
    // send(stateMachine, CustomEvent.SUB_NEXT3);
    // send(stateMachine, CustomEvent.SUB_NEXT1);
    // send(stateMachine, CustomEvent.NEXT);
    // send(stateMachine, CustomEvent.SUB_NEXT2);
    // stateMachine.stopReactively().subscribe();
    TimeUnit.SECONDS.sleep(30);
  }

  private void send(CustomEvent customEvent) throws Exception {
    int s = LocalTime.now().getNano();
    StateMachine<CustomState, CustomEvent> stateMachine =
        stateMachineFactory.getStateMachine("2048");
    int e = LocalTime.now().getNano();
      System.out.println(e-s);
    // stateMachine.startReactively().subscribe();
    // TODO: 手动持久化不太好处理timer等触发的状态转换
    customRedisStateMachinePersister.restore(stateMachine, "2048");
    log.info("-----------------------------------------------------------------------------------");
    log.info("当前状态{},开始发送{}", stateMachine.getState().getIds(), customEvent);
    stateMachine
        .sendEvent(
            Mono.just(
                MessageBuilder.withPayload(customEvent)
                    .setHeader(StateMachineMessageHeaders.HEADER_DO_ACTION_TIMEOUT, 5000)
                    .build()))
        .subscribe();
    stateMachine.getExtendedState().getVariables().put(CustomEvent.NEXT.name(), customEvent);
    CustomEvent event =
        (CustomEvent) stateMachine.getExtendedState().getVariables().get(CustomEvent.NEXT.name());
    log.info("扩展状态[state<{}>]", event);
    log.info("当前状态{},结束发送{}", stateMachine.getState().getIds(), customEvent);
    TimeUnit.SECONDS.sleep(1);
    log.info("-----------------------------------------------------------------------------------");
    customRedisStateMachinePersister.persist(stateMachine, "2048");
  }
}
