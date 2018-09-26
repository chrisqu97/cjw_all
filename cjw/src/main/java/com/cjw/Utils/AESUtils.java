package com.cjw.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AESUtils {

    /**
     * 密钥
     */
    private static final String PASSWORD = "CJW";

    /**
     * 算法名
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 默认加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
//            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey() {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(PASSWORD.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "cq2g4hwn3reXLtac5bF1JA==?1536441853127\n";
        //cq2g4hwn3reXLtac5bF1JA==?1536441853127

        System.out.println("s:" + s);

        String s1 = AESUtils.encrypt(s);
        System.out.println("s1:" + s1);

        System.out.println("s2:" + AESUtils.decrypt(s1));


    }

}
