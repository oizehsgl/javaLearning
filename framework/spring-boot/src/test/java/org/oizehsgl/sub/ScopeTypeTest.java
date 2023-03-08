package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.scopeType.ScopePrototype;
import org.oizehsgl.sub.scopeType.ScopePrototypeTest;
import org.oizehsgl.sub.scopeType.ScopeSingleton;
import org.oizehsgl.sub.scopeType.ScopeSingletonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * scopeTypeTest
 *
 * @author oizehsgl
 * @since 3/8/23
 */
@SpringBootTest
@Service
public class ScopeTypeTest {
    @Resource
    private ScopeSingleton scopeSingleton;
    @Resource
    private ScopeSingletonTest scopeSingletonTest;
    @Resource
    private ScopePrototype scopePrototype;
    @Resource
    private ScopePrototypeTest scopePrototypeTest;

    @Test
    public void testToString() {
        System.out.println(scopeSingleton.toString());
        System.out.println(scopeSingletonTest.toString());
        System.out.println(scopePrototype.toString());
        System.out.println(scopePrototypeTest.toString());
    }
}
