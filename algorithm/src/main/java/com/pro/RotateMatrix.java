package com.pro;

import java.util.Base64;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StopWatch;
import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ttl
 * 2020/4/8 11:57
 * @return
 */
public class RotateMatrix {

    public static void main(String[] args) {

        String encrypted = "ON0yLjLceNJUYi0FlQvTnmA7PAR8m2T5ZKyAI9bWVMhN2GY0r9B0Q8DSwXr/bSDlBGtLVnmy4RF3eG0kUa/CFq0gqILquKcR3zh8pdltlJdr+o6bLsD9yKMoDNGLP3Wtz9wSDkvO5zHM3EYULoYGSxszFnJK5LtrA5G9RMxta2E=";
        String prikey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOh9RKCChr3jJOIC" +
                "CsMK1rQSx7dcJeTInbXQNcxXst4G2Qssoqekf+YIMcXVjQY1QVEB0KNi0LDyB/2P" +
                "nrLLNyaQdrEci4Yc3KoJeJRPZYjB+gdILybCw1nIx08xkAA+RVvzjUi0ucxBT+u0" +
                "5yJ+5FdZ5R8KATIrdxnguWLjw+bFAgMBAAECgYEAr2HohmlQ+ihDJ5fAxJgFlbxh" +
                "GwqRr4BDsOdL3kX+Mg3aZ9qZLXwj28UsvwA1LYy5JEIJQWgG5KUAsCBK6Lfydl4G" +
                "eTkXEUL6TpwAVcNkEtMhAFkNVRpz2OMZBpGAA9GfQF3J9C+3zzSzmPudQkrowoew" +
                "tMFkZSTAY60lSudReWECQQD2Lq5HlqJVQWwf2giBR0aDTUjUhjm+l7Vdo0VuJ7Sx" +
                "UFzh1GOpkdNMxAc3RKL/eP+bzT3W7mGoMgLMaJHMoRL5AkEA8cLK97Xi0k/Qi1uF" +
                "o7M3TBo80AnuePJ8EjEdVCCGaCFI4f/Nv79dbFpm48QtR22iZeYQZwzrRxEJplfp" +
                "FnNZLQJAEUOszTBvKfNwlbtApXBOLZ8Z4G2ZVxhki7CLifIW5ehw2xV998JWQyfs" +
                "KaASnj/qDQ8TqyMEjjsTnyomL2eMYQJAG3iuBZ3Wa12EbgF1WxenRe+JT36BaZ7s" +
                "OEj6cy/K9hQqKvwdTheZrxFKtcD6AC7WEEwnOv590bJ+7Tb6FoH+9QJBAKuMrIC5" +
                "4Q7CDJm1kLsiOZO1SNGN50W/aoIOJtmTcuTJW1No1BdbZ79jtoa7c1BobK5LEdjd" +
                "N0yjAN9v0+go7u8=";

        String result = null;
        try {
            result = decrypt(encrypted, prikey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        String authString = "3aaac8af95b08126fada14be" + ":" + "ca005c1483f78cdfa45b13bc";
        byte[] authEncBytes = new byte[0];
        try {
            authEncBytes = Base64.getEncoder().encode(authString.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String authStringEnc = new String(authEncBytes);
        System.out.println(authStringEnc);
        try {
            System.out.println(Base64.getEncoder().encodeToString(authString.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map headerMap = new HashMap();
        headerMap.put("Content-Type", "application/json; charset=utf-8");
        headerMap.put("Accept", "*/*");
        headerMap.put("Authorization", "Basic " + authStringEnc);
        JSONObject requestBody=new JSONObject();
        requestBody.put("exID", 12);
        requestBody.put("loginToken", "asdfasd");
        System.out.println(requestBody.getString("exID"));
    }

    public static void rotate(int[][] matrix) {

    }

    public static String decrypt(String cryptograph, String prikey) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(prikey));
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);

        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte [] b = Base64.getDecoder().decode(cryptograph);
        return new String(cipher.doFinal(b));
    }
}
