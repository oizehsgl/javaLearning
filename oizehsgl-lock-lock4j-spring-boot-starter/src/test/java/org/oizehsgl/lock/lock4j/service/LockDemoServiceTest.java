package org.oizehsgl.lock.lock4j.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class LockDemoServiceTest {
  @Resource
  private LockDemoService lockDemoService;

  @Test
  void lock() throws InterruptedException {
    Thread thread1 = new Thread(()->{
        try {
            lockDemoService.lock("k","1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    Thread thread2 = new Thread(()->{
      try {
        lockDemoService.lock("k","2");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
  }


}
