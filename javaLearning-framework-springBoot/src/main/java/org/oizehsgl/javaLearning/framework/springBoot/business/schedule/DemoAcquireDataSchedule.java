package org.oizehsgl.javaLearning.framework.springBoot.business.schedule;

import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * demo定时任务
 *
 * @author yueyuanzhi
 */
@Component
public class DemoAcquireDataSchedule {
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(5000);
    }

    @SneakyThrows
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader2() {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(1000);
    }

    @SneakyThrows
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader3() {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(1000);
    }

    @SneakyThrows
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader4() {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(1000);
    }

    @SneakyThrows
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader5() {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(1000);
    }

    @SneakyThrows
    @Scheduled(cron = "${demo.cron:-}")
    public void plcReader6() {
        System.out.println(Thread.currentThread().getName() +
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date()));
        Thread.sleep(1000);
    }
}
