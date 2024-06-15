package org.oizehsgl.sm.spring.statemachine.service;

import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.nosql.redis.wrapper.properties.CustomRedisProperties;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineWrapper;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineWrapperFactory;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Slf4j
@Service
public class CustomStateMachineWrapperService {

  private final Map<String, CustomStateMachineWrapper> wrapperMap = new ConcurrentHashMap<>();

  @Resource private CustomStateMachineWrapperFactory customStateMachineWrapperFactory;

  @Resource
  private CustomRedisTemplate<StateMachineContext<CustomState, CustomEvent>> customRedisTemplate;

  @Resource private CustomRedisProperties customRedisProperties;

  public CustomStateMachineWrapper acquireStateMachineWrapper(String machineId) {
    return wrapperMap.computeIfAbsent(
        machineId,
        k -> {
          CustomStateMachineWrapper customStateMachineWrapper =
              customStateMachineWrapperFactory.getObject(k);
          if (Boolean.TRUE.equals(customRedisTemplate.hasKey(machineId))) {
            customStateMachineWrapper.restore();
          } else {
            customStateMachineWrapper.start();
            customStateMachineWrapper.persist();
          }
          return customStateMachineWrapper;
        });
  }

  public void releaseStateMachineWrapper(String machineId) {
    log.info("释放状态机[标识<{}>]", machineId);
    wrapperMap.remove(machineId);
    customRedisTemplate.delete(machineId);
  }
}
