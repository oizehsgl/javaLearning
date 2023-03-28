package org.oizehsgl.sub;

import com.google.common.base.MoreObjects;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * moreObjectsTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
@Slf4j
@SpringBootTest
public class MoreObjectsTest {
    @Test
    public void testFirstNonNull() {
        try {
            Integer n = null;
            System.out.println(MoreObjects.firstNonNull(1, 2));
            System.out.println(MoreObjects.firstNonNull(1, n));
            System.out.println(MoreObjects.firstNonNull(n, 2));
            System.out.println(MoreObjects.firstNonNull(n, n));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
