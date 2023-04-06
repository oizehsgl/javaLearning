package org.oizehsgl.sub.event;

import lombok.Getter;

/**
 * betaEvent
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Getter
public class BetaEvent extends BaseEvent {
    private String type;

    public BetaEvent(Object source, String type) {
        super(source);
        this.type = type;
    }
}
