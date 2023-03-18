package org.oizehsgl.sub;

import org.junit.Test;

/**
 * observerTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class ObserverTest {
    @Test
    public void testObserver() {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
