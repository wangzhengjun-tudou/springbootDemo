package com.example.springbootdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5(String input) {
        try {
            // 获取MD5算法实例
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // 更新要计算的内容
            messageDigest.update(input.getBytes());

            // 完成哈希计算，返回结果
            byte[] digest = messageDigest.digest();

            // 将结果转换为十六进制表示的字符串
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            // 处理算法不存在的异常
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    // 辅助方法，将字节数组转换为十六进制字符串
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

