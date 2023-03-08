package org.oizehsgl.sub.scopeType;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * scopeSingletonTest
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@Service
public class ScopeSingletonTest {
    @Resource
    private ScopeSingleton scopeSingleton;

    @Override
    public String toString() {
        return scopeSingleton.toString();
    }
}
