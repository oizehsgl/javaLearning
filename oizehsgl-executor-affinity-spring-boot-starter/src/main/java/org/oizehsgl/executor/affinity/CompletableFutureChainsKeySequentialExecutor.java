package org.oizehsgl.executor.affinity;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.Objects;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

/**
 * @author oizehsgl
 */
@Slf4j
public class CompletableFutureChainsKeySequentialExecutor {
  public static Cache<String, CompletableFuture<Void>> completableFutureChains =
      Caffeine.newBuilder().softValues().recordStats().build();

  public static void execute(@NonNull String key, @NonNull Runnable runnable) {
    completableFutureChains
        .asMap()
        .compute(
            key,
            (k, chains) ->
                Objects.isNull(chains)
                    ? CompletableFuture.runAsync(runnable)
                    : chains.thenRunAsync(runnable));
  }
}
