package org.oizehsgl.sub.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * asyncConfig
 *
 * @author oizehsgl
 * @since 4/11/23
 */
//??? 测试中断后spring自带的线程池会抛出异常，但是自己创建的线程池不会抛出异常
@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        int cpus = Runtime.getRuntime().availableProcessors();
        cpus = 8;
        threadPoolTaskExecutor.setCorePoolSize(cpus);
        threadPoolTaskExecutor.setMaxPoolSize(cpus * 2);
        threadPoolTaskExecutor.setQueueCapacity(cpus * 2);
        threadPoolTaskExecutor.setThreadNamePrefix("sync-");
        threadPoolTaskExecutor.setDaemon(true);
        threadPoolTaskExecutor.setPrestartAllCoreThreads(true);
        threadPoolTaskExecutor.setKeepAliveSeconds(1);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    //??? 异常处理不生效
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            /**
             * Handle the given uncaught exception thrown from an asynchronous method.
             *
             * @param ex     the exception thrown from the asynchronous method
             * @param method the asynchronous method
             * @param params the parameters used to invoke the method
             */
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                log.error("Unexpected exception occurred invoking async method: " + method, ex);
            }
        };
    }
}