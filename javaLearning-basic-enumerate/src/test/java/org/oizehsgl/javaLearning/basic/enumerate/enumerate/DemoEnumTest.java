package org.oizehsgl.javaLearning.basic.enumerate.enumerate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.EnumSet;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoEnumTest {
    @Test
    public void testSwitch() {
        DemoEnum demoEnum = DemoEnum.randomGetEnum();
        switch (demoEnum) {
            case DEMO1:
                Assert.isTrue(DemoEnum.DEMO1.getTypeName().equals(demoEnum.getTypeName()), demoEnum.getTypeName());
                break;
            case DEMO2:
                Assert.isTrue(DemoEnum.DEMO2.getTypeName().equals(demoEnum.getTypeName()), demoEnum.getTypeName());
                break;
            case DEMO3:
                Assert.isTrue(DemoEnum.DEMO3.getTypeName().equals(demoEnum.getTypeName()), demoEnum.getTypeName());
                break;
            default:
                throw new RuntimeException();
        }
    }
    // TODO: EnumSet和EnumMap测试  https://www.cnblogs.com/ziph/p/13068923.html
}