package org.oizehsgl.cache.caffeine;

import com.github.benmanes.caffeine.cache.*;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * @author oizehsgl
 */
@Slf4j
public class CacheDemo {
  // 手动加载
  Cache<String, Object> cache =
      Caffeine.newBuilder()
          // 初始容量
          .initialCapacity(10)
          // 计数驱逐
          // 最大容量
          .maximumSize(10)
          // 权重驱逐
          // 最大权重
          .maximumWeight(100)
          // 单个权重
          .weigher((Weigher<String, Object>) (key, value) -> key.length())
          // 时间驱逐
          // 读写后持续时间
          .expireAfterAccess(1, TimeUnit.SECONDS)
          // 写入后持续时间(将覆盖读写配置)
          .expireAfterWrite(1, TimeUnit.SECONDS)
          // 监听
          // 缓存移除监听
          .removalListener((key, val, removalCause) -> {})
          // 淘汰缓存监听
          .evictionListener(
              (key, val, removalCause) -> {
                log.info("缓存淘汰({})[key<{}>,val<{}>]", removalCause, key, val);
              })
          // 配置
          // 指定管理缓存调度
          .scheduler(Scheduler.systemScheduler())
          // 值软引用
          .softValues()
          // 键软引用
          .weakKeys()
          // 缓存命中统计
          .recordStats()
          .build();

  // 同步加载
  LoadingCache<String, String> loadingCache =
      Caffeine.newBuilder()
          // 更新缓存后持续时间
          .refreshAfterWrite(10, TimeUnit.SECONDS)
          .expireAfterWrite(10, TimeUnit.SECONDS)
          .expireAfterAccess(10, TimeUnit.SECONDS)
          .maximumSize(10)
          // 获取缓存方法
          .build(key -> LocalTime.now().toString());

  // 异步加载
  AsyncLoadingCache<String, String> asyncLoadingCache =
      Caffeine.newBuilder()
          // 刷新缓存后持续时间
          .refreshAfterWrite(1, TimeUnit.SECONDS)
          .expireAfterWrite(1, TimeUnit.SECONDS)
          .expireAfterAccess(1, TimeUnit.SECONDS)
          .maximumSize(10)
          // 获取值的方法
          .buildAsync(
              key -> {
                TimeUnit.SECONDS.sleep(3);
                return LocalTime.now().toString();
              });

  //
  //// 查找一个缓存元素， 没有查找到的时候返回null
  // Graph graph = cache.getIfPresent(key);
  //// 查找缓存，如果缓存不存在则生成缓存元素,  如果无法生成则返回null
  // graph = cache.get(key, k -> createExpensiveGraph(key));
  //// 添加或者更新一个缓存元素
  // cache.put(key, graph);
  //// 移除一个缓存元素
  // cache.invalidate(key);

}
