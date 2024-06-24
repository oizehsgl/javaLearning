package org.oizehsgl.lock.lock4j.service;

import com.baomidou.lock.LockTemplate;
import com.baomidou.lock.annotation.Lock4j;
import jakarta.annotation.Resource;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.lock.lock4j.custom.CustomLockFailureStrategy;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Slf4j
@Service
public class LockDemoService {
  @Resource private LockTemplate lockTemplate;

  @Lock4j(
      keys = {"#key", "#key"},
      expire = 30000,
      acquireTimeout = 0,
      failStrategy = CustomLockFailureStrategy.class)
  public void lock(String key, String value) throws InterruptedException {
    log.info("time<{}>,key<{}>,value<{}>", key, value, LocalTime.now());
    TimeUnit.SECONDS.sleep(3);
    log.info("time<{}>,key<{}>,value<{}>", key, value, LocalTime.now());
  }
}
