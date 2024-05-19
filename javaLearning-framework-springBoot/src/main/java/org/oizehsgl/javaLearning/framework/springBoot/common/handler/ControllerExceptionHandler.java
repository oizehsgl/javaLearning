package org.oizehsgl.javaLearning.framework.springBoot.common.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.common.base.ReturnResult;
import org.oizehsgl.javaLearning.framework.springBoot.common.constant.ReturnStatus;
import org.oizehsgl.javaLearning.framework.springBoot.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * controller层异常处理
 *
 * @author oizehsgl
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
  /**
   * 处理自定义的业务异常
   *
   * @param request
   * @param e
   * @return {@link ReturnResult}
   */
  @ExceptionHandler(BusinessException.class)
  public ReturnResult exceptionHandler(HttpServletRequest request, BusinessException e) {
    log.error("业务异常!", e);
    return ReturnResult.failure(ReturnStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * 处理空指针的异常
   *
   * @param request
   * @param e
   * @return {@link ReturnResult}
   */
  @ExceptionHandler(NullPointerException.class)
  public ReturnResult exceptionHandler(HttpServletRequest request, NullPointerException e) {
    log.error("空指针异常!", e);
    return ReturnResult.failure(ReturnStatus.BODY_NOT_MATCH);
  }

  /**
   * 处理其他异常
   *
   * @param request
   * @param e
   * @return {@link ReturnResult}
   */
  @ExceptionHandler(Exception.class)
  public ReturnResult exceptionHandler(HttpServletRequest request, Exception e) {
    log.error("未知异常!", e);
    return ReturnResult.failure(ReturnStatus.NOT_FOUND);
  }
}
