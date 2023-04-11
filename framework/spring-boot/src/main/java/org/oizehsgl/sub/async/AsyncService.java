package org.oizehsgl.sub.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * asyncService
 *
 * @author oizehsgl
 * @since 4/11/23
 */
@Slf4j
@Component
public class AsyncService {
    @Async
    public void async(Integer integer) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), integer);
    }
}