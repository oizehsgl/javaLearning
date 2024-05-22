package org.oizehsgl.spring.statemachine.persist.redis.runtime;//package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.runtime;
//
//import org.springframework.statemachine.StateMachineContext;
//import org.springframework.statemachine.data.redis.RedisRepositoryStateMachinePersist;
//import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
//import org.springframework.statemachine.persist.AbstractPersistingStateMachineInterceptor;
//import org.springframework.statemachine.persist.StateMachineRuntimePersister;
//import org.springframework.statemachine.support.StateMachineInterceptor;
//import org.springframework.util.Assert;
//
///**
// * @author oizehsgl
// */
//public class CustomRedisPersistingStateMachineInterceptor <S, E, T> extends AbstractPersistingStateMachineInterceptor<S, E, T>
//        implements StateMachineRuntimePersister<S, E, T> {
//
//    private final RedisRepositoryStateMachinePersist<S, E> persist;
//
//    /**
//     * Instantiates a new redis persisting state machine interceptor.
//     *
//     * @param redisStateMachineRepository the redis state machine repository
//     */
//    public CustomRedisPersistingStateMachineInterceptor(RedisStateMachineRepository redisStateMachineRepository) {
//        Assert.notNull(redisStateMachineRepository, "'redisStateMachineRepository' must be set");
//        this.persist = new RedisRepositoryStateMachinePersist<S, E>(redisStateMachineRepository);
//    }
//
//    /**
//     * Instantiates a new redis persisting state machine interceptor.
//     *
//     * @param persist the persist
//     */
//    public CustomRedisPersistingStateMachineInterceptor(RedisRepositoryStateMachinePersist<S, E> persist) {
//        Assert.notNull(persist, "'persist' must be set");
//        this.persist = persist;
//    }
//
//    @Override
//    public StateMachineInterceptor<S, E> getInterceptor() {
//        return this;
//    }
//
//    @Override
//    public void write(StateMachineContext<S, E> context, T contextObj) throws Exception {
//        persist.write(context, contextObj);
//    }
//
//    @Override
//    public StateMachineContext<S, E> read(T contextObj) throws Exception {
//        return persist.read(contextObj);
//    }
//}
