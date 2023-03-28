package org.oizehsgl.sub;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * objectuitlsTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
@SpringBootTest
public class ObjectutilsTest {
    @Test
    public void testFirstNonNull() {
        Integer n = null;
        System.out.println(ObjectUtils.firstNonNull(1, 2, n));
        System.out.println(ObjectUtils.firstNonNull(1, n, 3));
        System.out.println(ObjectUtils.firstNonNull(n, 2, 3));
        System.out.println(ObjectUtils.firstNonNull(n, n, n));
    }

    @Test
    public void testGetFirstNonNull() {
        @Data
        class InnerClass {
            Integer integer;
            String string;
        }
        InnerClass innerClass = new InnerClass();
        innerClass.setInteger(1);
        System.out.println(ObjectUtils.getFirstNonNull(innerClass::getInteger, innerClass::getString));
        innerClass.setString("2");
        System.out.println(ObjectUtils.getFirstNonNull(innerClass::getInteger, innerClass::getString));
        innerClass.setInteger(null);
        System.out.println(ObjectUtils.getFirstNonNull(innerClass::getInteger, innerClass::getString));
    }
}
