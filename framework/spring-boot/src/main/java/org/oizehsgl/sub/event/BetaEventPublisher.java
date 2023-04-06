package org.oizehsgl.sub.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * betaEventPublisher
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Component
public class BetaEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish() {
        applicationEventPublisher.publishEvent(new BetaEvent(this, EventConstant.TYPE_A));
    }
}
