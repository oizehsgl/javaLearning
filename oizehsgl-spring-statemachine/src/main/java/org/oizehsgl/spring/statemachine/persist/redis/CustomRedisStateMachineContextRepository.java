//package org.oizehsgl.spring.statemachine.persist.redis;
//
//import org.oizehsgl.nosql.redis.wrapper.serializer.CustomStringRedisSerializer;
//import org.oizehsgl.spring.statemachine.enums.DemoEvent;
//import org.oizehsgl.spring.statemachine.enums.DemoState;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author oizehsgl
// */
//@Component
//public class CustomRedisStateMachineContextRepository
//    extends RedisStateMachineContextRepositoryAdapter<DemoState, DemoEvent> {
//    /**
//     * Instantiates a new redis state machine context repository.
//     *
//     * @param redisTemplate the redis connection factory
//     */
//    public CustomRedisStateMachineContextRepository(RedisConnectionFactory connectionFactory, CustomStringRedisSerializer customStringRedisSerializer) {
//        super(connectionFactory,customStringRedisSerializer);
//    }
//}
