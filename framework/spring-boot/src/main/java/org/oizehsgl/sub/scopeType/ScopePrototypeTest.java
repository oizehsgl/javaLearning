package org.oizehsgl.sub.scopeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * scopePrototypeTest
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@Service
public class ScopePrototypeTest {
    @Autowired
    private ScopePrototype scopePrototype;

    @Override
    public String toString() {
        return scopePrototype.toString();
    }
}
