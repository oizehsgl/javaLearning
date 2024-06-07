package org.oizehsgl.sm.spring.statemachine.factory;

import ch.qos.logback.core.net.ssl.KeyManagerFactoryFactoryBean;
import ch.qos.logback.core.net.ssl.KeyStoreFactoryBean;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.core.KeyFactory;
import org.springframework.statemachine.StateMachine;

/**
 * @author oizehsgl
 */
public class CustomStateMachineWrapperFactory
    implements FactoryBean<StateMachine<CustomState, CustomEvent>> {

  @Override
  public StateMachine<CustomState, CustomEvent> getObject() throws Exception {
    return null;
  }

  @Override
  public Class<?> getObjectType() {
    return StateMachine.class;
  }
}
