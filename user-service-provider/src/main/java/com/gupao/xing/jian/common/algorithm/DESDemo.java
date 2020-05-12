package com.gupao.xing.jian.common.algorithm;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;

public class DESDemo {

    private static final Logger logger = LoggerFactory.getLogger(DESDemo.class);
    private static final String DES_ALGORITHM_TYPE = "DES";//DES默认算法类型-固定
    private static final int DES_CIPHER_LENGTH = 56;////DES密钥长度-固定
    private static final String DEFAULT_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";//默认的加密算法-固定

    public static void main(String[] args) {
        String content = "hello,中国;hello,世界!!!";
        String privateKey = "admin";
        String encryStr = encryptionContentByPrivateKey(content, privateKey);
        System.err.println("原始内容：\t" + content);
        System.err.println("加密后内容：\t" + encryStr);
        String decrypStr = decryptionContentByPrivateKey(encryStr, privateKey);
        System.err.println("解密后内容：\t" + decrypStr);
    }

    /**
     * 对加密内容进行解密
     *
     * @param encryptionContent 加密后内容
     * @param privateKey        密钥key
     * @return
     */
    public static String decryptionContentByPrivateKey(String encryptionContent, String privateKey) {
        String decryptionStr = null;
        try {
            // 创建密钥器
            Cipher cipher = Cipher.getInstance(DES_ALGORITHM_TYPE);
            //初始化密码器模式-解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKeySpecByPrivateKey(privateKey));
            byte[] decrypByte = cipher.doFinal(Base64.decodeBase64(encryptionContent));
            decryptionStr = new String(decrypByte, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptionStr;
    }

    /**
     * 内容加密
     *
     * @param content    待加密内容
     * @param privateKey 密钥key
     * @return
     */
    public static String encryptionContentByPrivateKey(String content, String privateKey) {
        String encryptionStr = null;
        try {
            //创建密钥器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //初始化密码器模式-加密模式
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKeySpecByPrivateKey(privateKey));
            //加密
            byte[] encryptionBytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            //base64转码返回
            encryptionStr = Base64.encodeBase64String(encryptionBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptionStr;
    }

    /**
     * 根据密钥生成加密密钥
     *
     * @param privateKey 密钥key
     * @return
     */
    public static SecretKeySpec getSecretKeySpecByPrivateKey(String privateKey) {
        //privateKey +="1";
        SecretKeySpec secretKeySpec = null;
        try {
            //生成指定算法密钥生成器KeyGenerator对象
            KeyGenerator keyGenerator = KeyGenerator.getInstance(DES_ALGORITHM_TYPE);
            keyGenerator.init(DES_CIPHER_LENGTH, new SecureRandom(privateKey.getBytes()));
            //生成一个密钥key
            SecretKey secretKey = keyGenerator.generateKey();
            //生成加密密钥
            secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), DES_ALGORITHM_TYPE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return secretKeySpec;
    }
}
