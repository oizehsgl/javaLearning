package org.oizehsgl.sub.event;

import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * alphaEventThirdListener
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Component
public class AlphaEventThirdListener {

    @Order(3)
    @Async
    @SneakyThrows
    @EventListener
    public void onApplicationEvent(AlphaEvent event) {
        System.out.printf("Class: %s Event: --> %s%n", this.getClass().getSimpleName(), event);
        TimeUnit.SECONDS.sleep(1);
    }
}
