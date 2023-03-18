package org.oizehsgl.sub;

import org.junit.Test;

/**
 * mediatorTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class MediatorTest {
    @Test
    public void testMediator() {
        User alice = new User("alice");
        User bob = new User("bob");
        alice.sendMessage("Hi! bob!");
        bob.sendMessage("Hello! alice!");
    }
}
