package org.oizehsgl.guava.cache.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 缓存
 *
 * @author oizehsgl
 */
@Slf4j
@Service
public class DemoCacheService {
  /** 线程池 */
  private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

  /** 缓存 */
  private final LoadingCache<Integer, String> cache =
      CacheBuilder.newBuilder()
          //// 是否需要统计缓存情况,该操作消耗一定的性能,生产环境应该去除
          // .recordStats()
          // 并发级别(可以同时写缓存的线程数)
          .concurrencyLevel(Runtime.getRuntime().availableProcessors())
          // 设置缓存容器的初始容量
          .initialCapacity(100)
          // region   ######## 缓存失效
          // region   ################ size-based eviction
          // 缓存条数 (当达到最大条数时使用LRU移除)
          .maximumSize(1000)
          //// 缓存重量(weigher为每一个缓存设置重量,当达到最大重量时使用LRU移除)
          // .maximumWeight(1000)
          // .weigher((k, v) -> 1)
          // endregion################
          // region   ################ time-based eviction
          //// 访问(读写)缓存后多久移除
          // .expireAfterAccess(10, TimeUnit.SECONDS)
          //// 写入缓存后多久移除
          // .expireAfterWrite(10, TimeUnit.SECONDS)
          //// 写入缓存后多久过期,只阻塞当前数据加载线程，其他线程返回旧值
          // .refreshAfterWrite(10, TimeUnit.SECONDS)
          // endregion################
          // region   ################ Reference-based Eviction
          //// 使用弱引用存储键. 当键没有其它(强或软)引用时,缓存项可以被垃圾回收. 因为垃圾回收仅依赖恒等式,使用弱引用键的缓存用而不是equals比较键
          // .weakKeys()
          //// 使用弱引用存储值. 当值没有其它(强或软)引用时,缓存项可以被垃圾回收. 因为垃圾回收仅依赖恒等式,使用弱引用值的缓存用而不是equals比较值.
          // .weakValues()
          //// 使用软引用存储值. 软引用只有在响应内存需要时,才按照全局最近最少使用的顺序回收.
          // 考虑到使用软引用的性能影响,我们通常建议使用更有性能预测性的缓存大小限定(基于容量回收). 使用软引用值的缓存同样用==而不是equals比较值
          // .softValues()
          // endregion################
          // endregion########
          // region   ######## 移除监听
          //// 默认情况下,监听器方法是在移除缓存时同步调用的. 因为缓存的维护和请求响应通常是同时进行的,代价高昂的监听器方法在同步模式下会拖慢正常的缓存请求.
          // 在这种情况下,你可以使用RemovalListeners.asynchronous(RemovalListener, Executor)把监听器装饰为异步操作.
          //// 缓存移除通知(同步)
          .removalListener(
              notification -> {
                log.info(
                    "缓存移除[cause<{}>,key<{}>,value<{}>]",
                    notification.getCause(),
                    notification.getKey(),
                    notification.getValue());
                log.error("{}", notification);
              })
          //// 缓存移除通知(异步)
          // .removalListener(RemovalListeners.asynchronous(notification -> {
          //    log.info("缓存移除[cause<{}>,key<{}>,value<{}>]", notification.getCause(),
          // notification.getKey(), notification.getValue());
          // }, executorService))
          // endregion
          // 指定CacheLoader(在缓存不存在时通过CacheLoader的实现自动加载缓存)
          .build(
              new CacheLoader<>() {
                // 执行任务(失效时并发获取线程等待新值)
                @Override
                public String load(Integer key) throws Exception {
                  Double nextDouble = new Random().nextDouble();
                  return String.valueOf(nextDouble);
                }
                //// 执行任务(失效时并发获取线程返回旧值)
                // @Override
                // public ListenableFuture<String> reload(Integer key, String oldValue) throws
                // Exception {
                //    ListenableFutureTask<String> futureTask = ListenableFutureTask.create(() -> {
                //        Integer nextInteger = new Random().nextInt();
                //        return String.valueOf(nextInteger);
                //    });
                //    executorService.execute(futureTask);
                //    return futureTask;
                // }
              });

  /**
   * 存在返回缓存值 不存在则调用Callable<? extends V> loader方法动态生成缓存值并存入缓存中
   *
   * @param key 键
   * @return {@link String}
   * @throws ExecutionException 执行异常
   */
  public String get(Integer key) {
    try {
      return cache.get(key);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 获取缓存
   *
   * @param key 键
   * @param callable 无缓存时调用
   * @return {@link String}
   * @throws ExecutionException 执行异常
   */
  public String get(Integer key, Callable<String> callable) {
    try {
      return cache.get(key, callable);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 存在则返回缓存 不存在则返回null
   *
   * @param key 键
   * @return {@link String}
   */
  public String getIfPresent(Integer key) {
    return cache.getIfPresent(key);
  }

  /**
   * 设置缓存
   *
   * @param key 键
   * @param value 值
   */
  public void put(Integer key, String value) {
    cache.put(key, value);
  }

  /**
   * 将缓存转换为Map
   *
   * @return {@link ConcurrentMap}<{@link Integer}, {@link String}>
   */
  public ConcurrentMap<Integer, String> asMap() {
    return cache.asMap();
  }

  /**
   * 失效缓存(单一)
   *
   * @param key 键
   */
  public void invalidate(Integer key) {
    cache.invalidate(key);
  }

  /**
   * 失效缓存(批量)
   *
   * @param keys 键集
   */
  public void invalidateAll(List<Integer> keys) {
    cache.invalidateAll(keys);
  }

  /** 失效缓存(全部) */
  public void invalidateAll() {
    cache.invalidateAll();
  }

  /**
   * 返回缓存统计状态
   *
   * @return {@link CacheStats}
   */
  public CacheStats stats() {
    return cache.stats();
  }
}
