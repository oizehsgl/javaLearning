package org.oizehsgl.sub.scopeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * scopeSingletonTest
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@Service
public class ScopeSingletonTest {
    @Autowired
    private ScopeSingleton scopeSingleton;

    @Override
    public String toString() {
        return scopeSingleton.toString();
    }
}
