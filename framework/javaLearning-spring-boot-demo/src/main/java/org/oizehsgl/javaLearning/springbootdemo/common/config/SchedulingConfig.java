package org.oizehsgl.javaLearning.springbootdemo.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 定时任务配置
 *
 * @author yueyuanzhi
 */
@Slf4j
@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

    /**
     * 重写方法指定自定义的线程池
     *
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(defaultCustomTaskScheduler());
    }

    /**
     * 默认定时任务线程池
     *
     * @return {@link TaskScheduler}
     */
    @Bean
    public TaskScheduler defaultCustomTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 设置核心线程数
        Runtime runtime = Runtime.getRuntime();
        int availableProcessors = runtime.availableProcessors();
        taskScheduler.setPoolSize(availableProcessors);
        // 设置线程名前缀
        taskScheduler.setThreadNamePrefix("defaultCustomScheduling-");
        return taskScheduler;
    }
}
