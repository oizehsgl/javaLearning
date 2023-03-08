package org.oizehsgl.sub.scopeType;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * scopeSingleton
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Component
public class ScopeSingleton {
}
