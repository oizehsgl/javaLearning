package org.oizehsgl.sub;

import org.junit.Test;

/**
 * proxyTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class ProxyTest {
    @Test
    public void testProxy() {
        Image image;
        image = new RealImage("/path/to/image");
        System.out.println("start display");
        image.display();
        System.out.println("end display");
        image = new ProxyImage("/path/to/image");
        System.out.println("start display");
        image.display();
        System.out.println("end display");
    }
}
