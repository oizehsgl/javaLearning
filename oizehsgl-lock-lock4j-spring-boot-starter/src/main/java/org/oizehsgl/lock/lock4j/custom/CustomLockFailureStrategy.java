package org.oizehsgl.lock.lock4j.custom;

import com.baomidou.lock.LockFailureStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomLockFailureStrategy implements LockFailureStrategy {

  @Override
  public void onLockFailure(String key, Method method, Object[] arguments) {
    log.error("抢占锁失败：{}==={}", key, method.getName());
  }
}
