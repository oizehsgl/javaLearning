package org.oizehsgl.lock.lock4j.service;

import com.baomidou.lock.LockTemplate;
import com.baomidou.lock.annotation.Lock4j;
import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
public class LockDemoService {
  @Resource private LockTemplate lockTemplate;

  @Lock4j(
      keys = {"#value", "#value"},
      expire = 7000,
      acquireTimeout = 4000)
  public void lock(String value) throws InterruptedException {
    TimeUnit.SECONDS.sleep(5);
    System.out.println(value);
  }
}
