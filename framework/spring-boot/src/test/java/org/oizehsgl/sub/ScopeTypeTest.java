package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.scopeType.ScopePrototype;
import org.oizehsgl.sub.scopeType.ScopePrototypeTest;
import org.oizehsgl.sub.scopeType.ScopeSingleton;
import org.oizehsgl.sub.scopeType.ScopeSingletonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public void testAddress() {
        String address1 = scopeSingleton.toString();
        String address2 = scopeSingletonTest.toString();
        Assert.isTrue(address1.equals(address2), "单例类地址应该相同");
        String address3 = scopePrototype.toString();
        String address4 = scopePrototypeTest.toString();
        Assert.isTrue(!address3.equals(address4), "原型类地址应该不同");
    }
}
