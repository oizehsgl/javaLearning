package org.oizehsgl.retry.spring.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class RetryServiceTest {

    @Resource private RetryService retryService;

    @Test
    void recoverNullPointerException() {
        retryService.exec(new NullPointerException());
    }

    @Test
    void recoverArithmeticException() {
        retryService.exec(new ArithmeticException());
        retryService.exec2(new ArithmeticException());
    }
    @Test
    void recoverException() {
        retryService.exec2(new ArrayIndexOutOfBoundsException());
        retryService.exec(new ArrayIndexOutOfBoundsException());
    }
}