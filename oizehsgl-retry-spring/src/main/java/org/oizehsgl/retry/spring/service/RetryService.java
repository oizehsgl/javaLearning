package org.oizehsgl.retry.spring.service;

import lombok.SneakyThrows;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
public interface RetryService {

    public void exec(Exception e);
}
