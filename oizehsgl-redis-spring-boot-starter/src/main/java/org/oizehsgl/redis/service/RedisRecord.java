//package org.oizehsgl.redis.template;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import org.springframework.data.redis.core.*;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: 徐一杰
// *
// * @date: 2022/4/3 @Description: 对RedisTemplate进行封装
// */
//@Component
//public record RedisRecord<V>(CustomRedisTemplate<V> redisTemplate) {
//
//
//  /***********      list 类型操作           **************/
//
//  /**
//   * 将list放入缓存
//   *
//   * @param key 键
//   * @param value 值
//   */
//  public void listRightPush(String key, V value) {
//    ListOperations<String, V> listOperations = redisTemplate.opsForList();
//    // 从队列右插入
//    listOperations.rightPush(key, value);
//  }
//
//  /**
//   * 将list放入缓存
//   *
//   * @param key 键
//   * @param value 值
//   * @return
//   */
//  public void listLeftPush(String key, V value) {
//    ListOperations<String, V> listOperations = redisTemplate.opsForList();
//    // 从队列右插入
//    listOperations.leftPush(key, value);
//  }
//
//  /**
//   * 将list放入缓存
//   *
//   * @param key 键
//   * @param value 值
//   * @return
//   */
//  public void listRightPushAll(String key, List<V> value) {
//    try {
//      redisTemplate.opsForList().rightPushAll(key, value);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 将list放入缓存
//   *
//   * @param key 键
//   * @param value 值
//   * @return
//   */
//  public void listLeftPushAll(String key, List<V> value) {
//    try {
//      redisTemplate.opsForList().leftPushAll(key, value);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 通过索引 获取list中的值
//   *
//   * @param key 键
//   * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
//   * @return
//   */
//  public Object listGetWithIndex(String key, long index) {
//    try {
//      return redisTemplate.opsForList().index(key, index);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//
//  /**
//   * 从队列左边弹出一条数据
//   *
//   * @param key
//   * @return
//   */
//  public V listLeftPop(String key) {
//    ListOperations<String, V> listOperations = redisTemplate.opsForList();
//    return listOperations.leftPop(key);
//  }
//
//  /**
//   * 从队列右边弹出一条数据
//   *
//   * @param key
//   * @return
//   */
//  public V listRightPop(String key) {
//    ListOperations<String, V> listOperations = redisTemplate.opsForList();
//    return listOperations.rightPop(key);
//  }
//
//  /**
//   * 获取list缓存的内容
//   *
//   * @param key 键
//   * @param start 开始
//   * @param end 结束 0 到 -1 代表所有值
//   * @return
//   */
//  public List<V> listRange(String key, long start, long end) {
//    try {
//      ListOperations<String, V> listOperations = redisTemplate.opsForList();
//      return listOperations.range(key, start, end);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//
//  /**
//   * 获取list缓存的长度
//   *
//   * @param key 键
//   * @return
//   */
//  public long listSize(String key) {
//    try {
//      return redisTemplate.opsForList().size(key);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return 0;
//    }
//  }
//
//  /**
//   * 根据索引修改list中的某条数据
//   *
//   * @param key 键
//   * @param index 索引
//   * @param value 值
//   * @return
//   */
//  public void listSet(String key, long index, V value) {
//    try {
//      redisTemplate.opsForList().set(key, index, value);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 移除N个值为value
//   *
//   * @param key 键
//   * @param count 移除多少个
//   * @param value 值
//   * @return 移除的个数
//   */
//  public long listRemove(String key, long count, V value) {
//    try {
//      return redisTemplate.opsForList().remove(key, count, value);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return 0;
//    }
//  }
//
//  /***********      hash 类型操作           **************/
//
//  /**
//   * 根据key和键获取value
//   *
//   * @param key 键 不能为null
//   * @param item 项 不能为null
//   * @return 值
//   */
//  public Object hashGet(String key, String item) {
//    return redisTemplate.opsForHash().get(key, item);
//  }
//
//  /**
//   * 获取key对应的所有键值
//   *
//   * @param key 键
//   * @return 对应的多个键值
//   */
//  public Map<Object, Object> hashMGet(String key) {
//    return redisTemplate.opsForHash().entries(key);
//  }
//
//  /**
//   * 添加map到hash中
//   *
//   * @param key 键
//   * @param map 对应多个键值
//   * @return true 成功 false 失败
//   */
//  public void hashMSet(String key, Map<String, Object> map) {
//    try {
//      redisTemplate.opsForHash().putAll(key, map);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 添加map到hash中，并设置过期时间
//   *
//   * @param key 键
//   * @param map 对应多个键值
//   * @param expireTime 时间(秒)
//   * @return true成功 false失败
//   */
//  public void hashMSet(String key, Map<String, Object> map, long expireTime) {
//    try {
//      redisTemplate.opsForHash().putAll(key, map);
//      if (expireTime > 0) {
//        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 向hash表中放入一个数据
//   *
//   * @param key 键
//   * @param hKey 项
//   * @param value 值
//   * @return true 成功 false失败
//   */
//  public <HString, HV> void hashPut(String key, HString hKey, HV value) {
//    try {
//      HashOperations<String, HString, HV> hashOperations = redisTemplate.opsForHash();
//      hashOperations.put(key, hKey, value);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 向hash表中放入一个数据，并设置过期时间
//   *
//   * @param key 键
//   * @param hKey 项
//   * @param value 值
//   * @param expireTime 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
//   * @return true 成功 false失败
//   */
//  public <HString, HV> void hashPut(String key, HString hKey, HV value, long expireTime) {
//    try {
//      redisTemplate.opsForHash().put(key, hKey, value);
//      if (expireTime > 0) {
//        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  /**
//   * 判断hash表中是否有该项的值
//   *
//   * @param key 键 不能为null
//   * @param hKey 项 不能为null
//   * @return true 存在 false不存在
//   */
//  public <HString, HV> boolean hashHasKey(String key, HString hKey) {
//    HashOperations<String, HString, HV> hashOperations = redisTemplate.opsForHash();
//    return hashOperations.hasKey(key, hKey);
//  }
//
//  /**
//   * 取出所有 value
//   *
//   * @param key
//   * @param <HK>
//   * @param <HV>
//   * @return
//   */
//  public <HString, HV> List<HV> hashValues(String key) {
//    HashOperations<String, HString, HV> hashOperations = redisTemplate.opsForHash();
//    return hashOperations.values(key);
//  }
//
//  /**
//   * 取出所有 hKey
//   *
//   * @param key
//   */
//  public <HString, HV> Set<HK> hashHKeys(String key) {
//    HashOperations<String, HString, HV> hashOperations = redisTemplate.opsForHash();
//    return hashOperations.keys(key);
//  }
//
//  /**
//   * 删除hash表中的键值，并返回删除个数
//   *
//   * @param key
//   * @param hashKeys
//   */
//  public <HString, HV> Long hashDelete(String key, Object... hashKeys) {
//    HashOperations<String, HString, HV> hashOperations = redisTemplate.opsForHash();
//    return hashOperations.delete(key, hashKeys);
//  }
//
//  /***********      set 类型操作           **************/
//  /**
//   * 将数据放入set缓存
//   *
//   * @param key 键
//   * @param values 值 可以是多个
//   */
//  public void setAdd(String key, V... values) {
//    redisTemplate.opsForSet().add(key, values);
//  }
//
//  /**
//   * 将set数据放入缓存，并设置过期时间
//   *
//   * @param key 键
//   * @param expireTime 时间(秒)
//   * @param values 值 可以是多个
//   */
//  public void setAdd(String key, long expireTime, V... values) {
//    redisTemplate.opsForSet().add(key, values);
//    if (expireTime > 0) {
//      redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//    }
//  }
//
//  /**
//   * 获取set缓存的长度
//   *
//   * @param key 键
//   * @return 长度
//   */
//  public long setSize(String key) {
//    try {
//      return redisTemplate.opsForSet().size(key);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return 0;
//    }
//  }
//
//  /**
//   * 根据key获取Set中的所有值
//   *
//   * @param key
//   * @return java.util.Set<V>
//   */
//  public Set<V> setValues(String key) {
//    SetOperations<String, V> setOperations = redisTemplate.opsForSet();
//    return setOperations.members(key);
//  }
//
//  /**
//   * 根据value从一个set中查询,是否存在
//   *
//   * @param key 键
//   * @param value 值
//   * @return true 存在 false不存在
//   */
//  public boolean setHasKey(String key, V value) {
//    return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(key, value));
//  }
//
//  /**
//   * 根据value删除，并返回删除的个数
//   *
//   * @param key
//   * @param value
//   * @return 删除的个数
//   */
//  public Long setDelete(String key, Object... value) {
//    SetOperations<String, V> setOperations = redisTemplate.opsForSet();
//    return setOperations.remove(key, value);
//  }
//
//  /***********      zset 类型操作           **************/
//  /**
//   * 在 zset中插入一条数据
//   *
//   * @param key
//   * @param value
//   * @param score
//   */
//  public void zSetAdd(String key, V value, long score) {
//    ZSetOperations<String, V> zSetOperations = redisTemplate.opsForZSet();
//    zSetOperations.add(key, value, score);
//  }
//
//  /**
//   * 得到分数在 score1，score2 之间的值
//   *
//   * @param key
//   * @param score1
//   * @param score2
//   * @return java.util.Set<V>
//   */
//  public Set<V> zSetValuesRange(String key, long score1, long score2) {
//    ZSetOperations<String, V> zSetOperations = redisTemplate.opsForZSet();
//    return zSetOperations.range(key, score1, score2);
//  }
//
//  /**
//   * 根据value删除，并返回删除个数
//   *
//   * @param key
//   * @param value
//   * @return 删除个数
//   */
//  public Long zSetDeleteByValue(String key, Object... value) {
//    ZSetOperations<String, V> zSetOperations = redisTemplate.opsForZSet();
//    return zSetOperations.remove(key, value);
//  }
//
//  /**
//   * 删除多个，并返回删除个数
//   *
//   * @param key
//   * @param size1
//   * @param size2
//   * @return 删除个数
//   */
//  public Long zSetDeleteRange(String key, long size1, long size2) {
//    ZSetOperations<String, V> zSetOperations = redisTemplate.opsForZSet();
//    return zSetOperations.removeRange(key, size1, size2);
//  }
//
//  /**
//   * 删除分数区间内元素，并返回删除个数
//   *
//   * @param key
//   * @param score1
//   * @param score2
//   * @return 删除个数
//   */
//  public Long zSetDeleteByScore(String key, long score1, long score2) {
//    ZSetOperations<String, V> zSetOperations = redisTemplate.opsForZSet();
//    return zSetOperations.removeRangeByScore(key, score1, score2);
//  }
//}
