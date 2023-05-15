package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;

/**
 * aesTest
 *
 * @author oizehsgl
 * @since 5/15/23
 */
public class AESTest {
    @Test
    public void test(){
        final String secretKey = "abrydw0123456789";

        String originalString = "ZLWdds@8699";
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}