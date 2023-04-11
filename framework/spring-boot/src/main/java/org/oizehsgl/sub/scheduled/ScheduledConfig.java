package org.oizehsgl.sub.scheduled;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * scheduledConfig
 *
 * @author oizehsgl
 * @since 4/11/23
 */
//@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
    /**
     * Callback allowing a {@link TaskScheduler
     * TaskScheduler} and specific {@link Task Task}
     * instances to be registered against the given the {@link ScheduledTaskRegistrar}.
     *
     * @param taskRegistrar the registrar to be configured.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        int cpus = Runtime.getRuntime().availableProcessors();
        cpus = 2;
        threadPoolTaskScheduler.setPoolSize(cpus);
        threadPoolTaskScheduler.setThreadNamePrefix("schedule-");
        threadPoolTaskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        threadPoolTaskScheduler.initialize();
        taskRegistrar.setScheduler(threadPoolTaskScheduler);
    }
}
