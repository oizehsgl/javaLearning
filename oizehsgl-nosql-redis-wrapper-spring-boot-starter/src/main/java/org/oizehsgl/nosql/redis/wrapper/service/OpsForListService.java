package org.oizehsgl.nosql.redis.wrapper.service;

import java.util.Collection;
import java.util.Set;
import org.springframework.data.redis.core.RedisCallback;

/**
 * @author oizehsgl
 */
public interface OpsForListService<K, V> {

  void set(K key, V value);

  void set(K key, V value, long time);

  V get(K key);

  void delete(K key);

  void delete(Collection<String> keys);

  boolean expire(K key, long time);

  Long getExpire(K key);

  void persist(K key);

  boolean hasKey(K key);

  Long increment(K key, long delta);

  Long decrement(K key, long delta);

  void addSet(K key, V value);

  Set<V> getSet(K key);

  Set<String> keys(K pattern);

  void deleteSet(K key, V value);

  V execute(RedisCallback<V> redisCallback);
}
