package org.oizehsgl.redis.service.impl;

import jakarta.annotation.Resource;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.oizehsgl.redis.service.RedisOpsService;
import org.oizehsgl.redis.template.CustomRedisTemplate;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
public class RedisOpsServiceImpl<V> extends RedisOpsService<V>{
  @Resource private CustomRedisTemplate<V> customRedisTemplate;

  @Override
  public void set(String key, V value, long time) {
    customRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
  }

  @Override
  public void set(String key, V value) {
    customRedisTemplate.opsForValue().set(key, value);
  }

  @Override
  public V get(String key) {
    return customRedisTemplate.opsForValue().get(key);
  }

  @Override
  public void delete(String key) {
    customRedisTemplate.delete(key);
  }

  @Override
  public void delete(Collection<String> keys) {
    customRedisTemplate.delete(keys);
  }

  @Override
  public boolean expire(String key, long time) {
    return Boolean.TRUE.equals(customRedisTemplate.expire(key, time, TimeUnit.SECONDS));
  }

  @Override
  public Long getExpire(String key) {
    return customRedisTemplate.getExpire(key, TimeUnit.SECONDS);
  }

  @Override
  public void persist(String key) {
    customRedisTemplate.boundValueOps(key).persist();
  }

  @Override
  public boolean hasKey(String key) {
    return Boolean.TRUE.equals(customRedisTemplate.hasKey(key));
  }

  @Override
  public Long increment(String key, long delta) {
    return customRedisTemplate.opsForValue().increment(key, delta);
  }

  @Override
  public Long decrement(String key, long delta) {
    return customRedisTemplate.opsForValue().increment(key, -delta);
  }

  @Override
  @SuppressWarnings("unchecked")
  public void addSet(String key, V value) {
    customRedisTemplate.opsForSet().add(key, value);
  }

  @Override
  public Set<V> getSet(String key) {
    return customRedisTemplate.opsForSet().members(key);
  }

  @Override
  public Set<String> keys(String pattern) {
    return customRedisTemplate.keys(pattern);
  }

  @Override
  public void deleteSet(String key, V value) {
    customRedisTemplate.opsForSet().remove(key, value);
  }

  @Override
  public V execute(RedisCallback<V> redisCallback) {
    return customRedisTemplate.execute(redisCallback);
  }
}
