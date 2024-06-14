package org.oizehsgl.sm.spring.statemachine.factory;

import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.statemachine.access.StateMachineAccessor;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author oizehsgl
 */
public class StateMachineAdapter<S, E> implements StateMachine<S, E> {
  @Override
  public State<S, E> getInitialState() {
    return null;
  }

  @Override
  public ExtendedState getExtendedState() {
    return null;
  }

  @Override
  public StateMachineAccessor<S, E> getStateMachineAccessor() {
    return null;
  }

  @Override
  public void setStateMachineError(Exception exception) {}

  @Override
  public boolean hasStateMachineError() {
    return false;
  }

  @Override
  public UUID getUuid() {
    return null;
  }

  @Override
  public String getId() {
    return "";
  }

  @Override
  public void start() {}

  @Override
  public void stop() {}

  @Override
  public boolean sendEvent(Message<E> event) {
    return false;
  }

  @Override
  public boolean sendEvent(E event) {
    return false;
  }

  @Override
  public Flux<StateMachineEventResult<S, E>> sendEvents(Flux<Message<E>> events) {
    return null;
  }

  @Override
  public Flux<StateMachineEventResult<S, E>> sendEvent(Mono<Message<E>> event) {
    return null;
  }

  @Override
  public Mono<List<StateMachineEventResult<S, E>>> sendEventCollect(Mono<Message<E>> event) {
    return null;
  }

  @Override
  public State<S, E> getState() {
    return null;
  }

  @Override
  public Collection<State<S, E>> getStates() {
    return List.of();
  }

  @Override
  public Collection<Transition<S, E>> getTransitions() {
    return List.of();
  }

  @Override
  public boolean isComplete() {
    return false;
  }

  @Override
  public void addStateListener(StateMachineListener<S, E> listener) {}

  @Override
  public void removeStateListener(StateMachineListener<S, E> listener) {}
}
