package org.oizehsgl.redis.template;

import org.oizehsgl.redis.serializer.CustomGenericJackson2JsonRedisSerializer;
import org.oizehsgl.redis.serializer.CustomStringRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomRedisTemplate<V> extends RedisTemplate<String, V> {
  public CustomRedisTemplate(
      RedisConnectionFactory redisConnectionFactory,
      CustomStringRedisSerializer customStringRedisSerializer,
      CustomGenericJackson2JsonRedisSerializer customGenericJackson2JsonRedisSerializer) {
    // 构造函数注入RedisConnectionFactory设置到父类
    super.setConnectionFactory(redisConnectionFactory);

    // String类型的key/value序列化
    super.setKeySerializer(customStringRedisSerializer);
    super.setValueSerializer(customGenericJackson2JsonRedisSerializer);

    // Hash类型的key/value序列化
    super.setHashKeySerializer(customStringRedisSerializer);
    super.setHashValueSerializer(customGenericJackson2JsonRedisSerializer);
  }
}
