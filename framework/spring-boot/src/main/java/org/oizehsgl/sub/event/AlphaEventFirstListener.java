package org.oizehsgl.sub.event;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * alphaEventFirstListener
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@Component
public class AlphaEventFirstListener implements ApplicationListener<AlphaEvent> {
    @Async
    @Override
    @SneakyThrows
    public void onApplicationEvent(AlphaEvent event) {
        System.out.printf("Class: %s Event: --> %s%n", this.getClass().getSimpleName(), event);
        TimeUnit.SECONDS.sleep(1);
    }
}
