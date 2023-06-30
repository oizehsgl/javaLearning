package com.example.throwable;

import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 * @since 6/30/23
 */
@Component
public class ErrorStackOverflow {
    public long fibonacci(long i, long n1, long n2) {
        if (i == 1) return n1;
        return fibonacci(i - 1, n2, n1 + n2);
    }
}
