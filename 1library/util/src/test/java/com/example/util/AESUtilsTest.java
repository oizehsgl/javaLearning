package com.example.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 * @since 6/27/23
 */
@SpringBootTest
public class AESUtilsTest {
    @Test
    public void test() {
        final String password = "abrydw0123456789";
        String plaintext = "ZLWdds@8699";
        String ciphertext = AESUtils.encrypt(plaintext, password);
        String plaintextDecode = AESUtils.decrypt(ciphertext, password);
        System.out.println(plaintext);
        System.out.println(ciphertext);
        System.out.println(plaintextDecode);
    }
}
