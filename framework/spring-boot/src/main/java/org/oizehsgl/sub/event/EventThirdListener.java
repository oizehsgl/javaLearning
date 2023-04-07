package org.oizehsgl.sub.event;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * eventThirdListener
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Component
public class EventThirdListener {

    @Async
    @SneakyThrows
    @Order(3)
    @EventListener(value = {BetaEvent.class})
    public void onApplicationEvent(BaseEvent event) {
        System.out.printf("Class: %s Event: --> %s%n", this.getClass().getSimpleName(), event);
        TimeUnit.SECONDS.sleep(1);
    }
}