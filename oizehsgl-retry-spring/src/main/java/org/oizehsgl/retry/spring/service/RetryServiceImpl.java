package org.oizehsgl.retry.spring.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author oizehsgl
 */
@Slf4j
@Service
public class RetryServiceImpl implements RetryService {
  public static class TwoException extends RuntimeException {
    public TwoException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  private class OneExecption extends RuntimeException {
    public OneExecption(String message, Throwable cause) {
      super(message, cause);
    }
  }

  @SneakyThrows
  // interceptor: 指定方法拦截器的bean名称
  // value: 抛出指定异常才会重试
  // include: 和value一样,默认为空,当exclude也为空时,默认异常
  // exclude: 指定不处理的异常
  // maxAttempts: 最大重试次数,默认3次
  // backoff: 重试等待策略,默认使用@Backoff,@Backoff的value默认为1000L,我们设置为2000L,multiplier默认为0,表示固定暂停1秒后进行重试
  @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000L, multiplier = 2))
  public void exec(Exception e) {
    try {
      log.info("执行[time<{}>]", LocalTime.now());
      throw e;
    } catch (Exception ex) {
      throw new RuntimeException();
    }
  }

  /** 返回值必须相同,第一个参数为异常 */
  @Recover
  public void recoverNullPointerException(NullPointerException nullPointerException, Exception e) {
    log.error("空指针异常[e<{}>]", e.toString());
  }

  @Recover
  public void recoverArithmeticException(ArithmeticException arithmeticException, Exception e) {
    log.error("算术异常[e<{}>]", e.toString());
  }

  @Recover
  public void recoverException(Exception exception, Exception e) {
    log.error("其余异常[e<{}>]", e.toString());
  }

  @SneakyThrows
  @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000L, multiplier = 2))
  public void exec2(Exception e) {
     log.info("执行2[time<{}>]", LocalTime.now());
    throw new TwoException("2其余异常信息", e);
  }

  @Recover
  public void recover2(TwoException exception, Exception e) {
    log.error("2其余异常[e<{}>]", e.toString(),exception);
  }
}
