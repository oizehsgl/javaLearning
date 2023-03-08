package org.oizehsgl.sub.scopeType;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * scopePrototypeTest
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@Service
public class ScopePrototypeTest {
    @Resource
    private ScopePrototype scopePrototype;

    @Override
    public String toString() {
        return scopePrototype.toString();
    }
}
