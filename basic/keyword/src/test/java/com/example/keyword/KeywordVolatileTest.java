package com.example.keyword;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 * @since 6/29/23
 */
@SpringBootTest
public class KeywordVolatileTest {

    @Test
    public void testReordering() {
        KeywordVolatile keywordVolatile = new KeywordVolatile();
        int count = 0;
        while (true) {
            count++;
            try {
                int sum = keywordVolatile.reordering();
                if (sum == 0) {
                    System.out.printf("%-10d %d%n", count, sum);
                    break;
                }
                System.out.printf("%-10d %d%n", count, sum);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
