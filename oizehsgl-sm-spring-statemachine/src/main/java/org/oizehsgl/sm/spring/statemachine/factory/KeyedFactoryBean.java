package org.oizehsgl.sm.spring.statemachine.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oizehsgl
 */
public interface KeyedFactoryBean<K, V> {

  V getObject(K k) throws Exception;
}
