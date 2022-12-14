package org.oizehsgl.sub.util.network;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author oizehsgl
 * @since 2023/1/9
 */
public class CheckTest {

    @Test
    public void checkIpPort() {
    }

    @Test
    public void checkIp() {
        Assert.assertTrue(Check.checkIp("127.0.0.1"));
        System.out.println(Check.checkIp("138.0.0.199"));
        System.out.println(Check.checkIp("119.167.159.250"));
        System.out.println(Check.checkIp("119.168.159.250"));
        System.out.println(Check.checkIp("138.168.159.250"));
        Assert.assertFalse(Check.checkIp("138.0.0.199"));
    }
}