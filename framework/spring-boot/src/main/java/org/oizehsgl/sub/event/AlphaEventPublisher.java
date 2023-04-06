package org.oizehsgl.sub.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * alphaEventPublisher
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Component
public class AlphaEventPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish() {
        applicationContext.publishEvent(new AlphaEvent(this));
    }
}
