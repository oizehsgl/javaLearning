package org.oizehsgl.retry.spring.retry;

import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.*;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.time.Duration;

/**
 * @author oizehsgl
 */
public class CustomRetryTemplate extends RetryTemplate {
    public CustomRetryTemplate() {
        // region^^^# 重试策略
        //NeverRetryPolicy: 不重试
        //AlwaysRetryPolicy: 一直重试
        //SimpleRetryPolicy: 默认最多重试3次
        //TimeoutRetryPolicy: 默认在1秒内失败都会重试
        //ExpressionRetryPolicy: 符合表达式就会重试
        //CircuitBreakerRetryPolicy: 增加了熔断的机制，如果不在熔断状态，则允许重试需设置3个参数openTimeout,resetTimeout和delegate
        //CompositeRetryPolicy: 可以乐观或者悲观组合多个重试策略
        this.setRetryPolicy(new SimpleRetryPolicy());
        // endregion#
        // region^^^# 退避策略
        //FixedBackOffPolicy: 默认固定延迟1秒后执行下一次重试
        //ExponentialBackOffPolicy: 指数递增延迟执行重试
        //ExponentialRandomBackOffPolicy: 在指数策略上增加随机性
        //UniformRandomBackOffPolicy: 与质数随机策略区别是延迟会不停递增,而是在固定的区间随机
        //StatelessBackOffPolicy: 这个说明是无状态的,所谓无状态就是对上次的退避无感知
        // endregion#
    }
}
