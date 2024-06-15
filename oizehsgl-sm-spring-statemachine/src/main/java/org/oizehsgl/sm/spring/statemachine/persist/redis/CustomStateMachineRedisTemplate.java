package org.oizehsgl.sm.spring.statemachine.persist.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStateMachineRedisTemplate<V> extends RedisTemplate<String, V> {

  public static final String BEAN_NAME = "customStateMachineRedisTemplate";

  public CustomStateMachineRedisTemplate(
      RedisConnectionFactory redisConnectionFactory,
      @Qualifier(CustomStateMachineStringRedisSerializer.BEAN_NAME)
      StringRedisSerializer stringRedisSerializer) {

    // 构造函数注入RedisConnectionFactory设置到父类
    super.setConnectionFactory(redisConnectionFactory);

    // String类型的key/value序列化
    super.setKeySerializer(stringRedisSerializer);
    // super.setValueSerializer(customGenericJackson2JsonRedisSerializer);

    // Hash类型的key/value序列化
    super.setHashKeySerializer(stringRedisSerializer);
    // super.setHashValueSerializer(customGenericJackson2JsonRedisSerializer);

    // 设置支持事务
    super.setEnableTransactionSupport(true);

    // 初始化操作
    super.afterPropertiesSet();
    System.out.println();
  }
}
