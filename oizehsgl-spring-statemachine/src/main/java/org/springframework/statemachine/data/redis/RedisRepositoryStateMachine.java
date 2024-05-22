package org.springframework.statemachine.data.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.statemachine.data.RepositoryStateMachine;

/**
 * @author oizehsgl
 */
@Getter
@Setter
@RedisHash("APP:FSM")
public class RedisRepositoryStateMachine extends RepositoryStateMachine {
    @Id
    private String id;
    private String machineId;
    private String state;
    private byte[] stateMachineContext;
}
