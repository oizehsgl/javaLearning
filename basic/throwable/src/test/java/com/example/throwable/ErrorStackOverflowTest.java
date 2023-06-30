package com.example.throwable;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErrorStackOverflowTest {
    @Resource
    ErrorStackOverflow errorStackOverflow;

    @Test
    public void testRecursion() {
        try {
            //System.out.println(errorStackOverflow.fibonacci(7355, 1, 2));
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
