package org.oizehsgl.sub.scheduled;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务测试
 *
 * @author oizehsgl
 * @since 3/10/23
 */
@Component
public class ScheduledTest {
    //@Async
    //@Scheduled(cron = "*/2 * * * * ?", zone = "Asia/Shanghai")
    public void cron() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%-20s %s\n", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    //@Async
    //@Scheduled(initialDelay = 1, fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void fixedRate() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%-20s %s\n", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    //@Async
    //@Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void fixedDelay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%-20s %s\n", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    //@Scheduled(initialDelayString = "PT1S", fixedRateString = "#{T(java.util.concurrent.ThreadLocalRandom).current().nextLong(1, 10)}",timeUnit = TimeUnit.SECONDS)
    public void fixedRateString() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%-20s %s\n", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }

    //@Scheduled(initialDelayString = "PT1S", fixedDelayString = "PT2S")
    public void fixedDelayString() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%-20s %s\n", Thread.currentThread().getStackTrace()[1].getMethodName(), new Date());
    }
}
