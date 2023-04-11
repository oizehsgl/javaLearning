package org.oizehsgl.sub.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * scheduledService
 *
 * @author oizehsgl
 * @since 3/10/23
 */
@Slf4j
//@Component
public class ScheduledService {
    int second = 5;

    private int getSecond() {
        return second > 0 ? second-- : 0;
    }

    @Scheduled(cron = "*/2 * * * * ?", zone = "Asia/Shanghai")
    public void cron() throws InterruptedException {
        TimeUnit.SECONDS.sleep(getSecond());
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    @Scheduled(initialDelay = 1, fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void fixedRate() throws InterruptedException {
        TimeUnit.SECONDS.sleep(getSecond());
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void fixedDelay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(getSecond());
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    @Scheduled(initialDelayString = "PT1S", fixedRateString = "#{T(java.util.concurrent.ThreadLocalRandom).current().nextLong(1, 10)}", timeUnit = TimeUnit.SECONDS)
    public void fixedRateString() throws InterruptedException {
        TimeUnit.SECONDS.sleep(getSecond());
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    @Scheduled(initialDelayString = "PT1S", fixedDelayString = "PT2S")
    public void fixedDelayString() throws InterruptedException {
        TimeUnit.SECONDS.sleep(getSecond());
        log.info("<{}>: <{}>", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }
}
