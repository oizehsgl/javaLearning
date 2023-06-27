package com.example.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * AES加密解密
 *
 * @author oizehsgl
 * @since 6/27/23
 */
public class AESUtils {
    private static final String encodeRule = "f";
    private static final String AES_ALGORITHM = "AES";

    /**
     * 加密
     *
     * @param plaintext 明文
     * @param password  密码
     * @return {@link String}
     */
    public static String encrypt(final String plaintext, final String password) {
        try {
            // 密码文本-->密码字节-->摘要字节
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            passwordBytes = messageDigest.digest(passwordBytes);
            passwordBytes = Arrays.copyOf(passwordBytes, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(passwordBytes, AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // AES: 加密模式
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            // 明文文本-->明文字节
            byte[] plaintextBytes = plaintext.getBytes(StandardCharsets.UTF_8);
            // 明文字节-->密文字节
            byte[] ciphertextBytes = cipher.doFinal(plaintextBytes);
            // 密文字节-->密文文本
            String ciphertext = Base64.getEncoder().encodeToString(ciphertextBytes);
            return ciphertext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 解密
     *
     * @param ciphertext 密文
     * @param password   密码
     * @return {@link String}
     */
    public static String decrypt(String ciphertext, String password) {
        try {
            // 密码文本-->密码字节-->摘要字节
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            passwordBytes = messageDigest.digest(passwordBytes);
            passwordBytes = Arrays.copyOf(passwordBytes, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(passwordBytes, AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // AES: 解密模式
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            // 密文文本-->密文字节
            byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
            // 密文字节-->明文字节
            byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);
            // 明文字节-->明文文本
            String plaintext = new String(plaintextBytes);
            return plaintext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
