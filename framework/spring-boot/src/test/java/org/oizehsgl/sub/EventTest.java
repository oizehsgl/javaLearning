package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.event.AlphaEventPublisher;
import org.oizehsgl.sub.event.BetaEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * eventTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@SpringBootTest
public class EventTest {
    @Autowired
    private AlphaEventPublisher alphaEventPublisher;
    @Autowired
    private BetaEventPublisher betaEventPublisher;

    @Test
    public void testPublisher() throws InterruptedException {
        alphaEventPublisher.publish();
        betaEventPublisher.publish();
        TimeUnit.SECONDS.sleep(2);
    }
}
