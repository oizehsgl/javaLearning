package org.oizehsgl.sub.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * globalExceptionHandler
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理未知异常
     *
     * @param httpServletRequest 请求
     * @param e                  异常
     * @return 封装数据
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        log.error(e.getMessage(), e);
        return R.failure(RStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理业务异常
     *
     * @param httpServletRequest 请求
     * @param e                  异常
     * @return 封装数据
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
        log.error(e.getMessage(), e);
        return R.failure(e);
    }

    /**
     * 处理空指针的异常
     *
     * @param httpServletRequest 请求
     * @param e                  异常
     * @return 封装数据
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest httpServletRequest, NullPointerException e) {
        log.error(e.getMessage(), e);
        return R.failure(RStatus.INTERNAL_SERVER_ERROR);
    }
}
