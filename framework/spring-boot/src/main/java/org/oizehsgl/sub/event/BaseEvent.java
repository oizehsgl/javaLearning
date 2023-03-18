package org.oizehsgl.sub.event;

import org.springframework.context.ApplicationEvent;

/**
 * baseEvent
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class BaseEvent extends ApplicationEvent {
    public BaseEvent(Object source) {
        super(source);
    }
}
