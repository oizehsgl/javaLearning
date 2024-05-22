package org.springframework.statemachine.data.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.statemachine.data.RepositoryStateMachine;

/**
 * @author oizehsgl
 */
@RedisHash("RedisRepositoryStateMachineYYYYYYYYYYYYYYYYYYYYY")
public class RedisRepositoryStateMachine extends RepositoryStateMachine {

    @Id
    private String id;

    private String machineId;
    private String state;
    private byte[] stateMachineContext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    @Override
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public byte[] getStateMachineContext() {
        return stateMachineContext;
    }

    public void setStateMachineContext(byte[] stateMachineContext) {
        this.stateMachineContext = stateMachineContext;
    }
}
