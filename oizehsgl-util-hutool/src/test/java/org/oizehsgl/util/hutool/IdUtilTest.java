package org.oizehsgl.util.hutool;

import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
public class IdUtilTest {
    @Test
    public void test() {
    System.out.println(IdUtil.fastUUID());
        System.out.println(IdUtil.fastSimpleUUID());
    }
}
