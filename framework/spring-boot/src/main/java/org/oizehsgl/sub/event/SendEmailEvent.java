package org.oizehsgl.sub.event;

import lombok.Getter;

/**
 * sendEmailEvent
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class SendEmailEvent extends BaseEvent {

    @Getter
    private Long id;

    public SendEmailEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }
}
