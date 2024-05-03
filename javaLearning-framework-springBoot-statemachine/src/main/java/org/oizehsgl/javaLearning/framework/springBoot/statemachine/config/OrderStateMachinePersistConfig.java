package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.data.redis.RedisPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;

/**
 * 订单状态机持久化配置
 *
 * @author yueyuanzhi
 */
@Slf4j
@Configuration
public class OrderStateMachinePersistConfig {
    @Bean
    public StateMachineRuntimePersister<OrderState, OrderEvent, String> stateMachineRuntimePersister(
            RedisStateMachineRepository repository) {
        return new RedisPersistingStateMachineInterceptor<>(repository);
    }
}
