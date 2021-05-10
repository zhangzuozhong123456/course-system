package com.rainng.coursesystem.util;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Md5Encrypt {
    //字节转十六进制字符串
    private static String byteToHexString(byte b) {
        int bInt = b;
        if (bInt < 0) {
            b ^= (1 << 7);
            bInt = b + (1 << 7);
        }

        String lowBit = Integer.toHexString(bInt / 16);
        String highBit = Integer.toHexString(bInt % 16);

        return lowBit + highBit;
    }
    //字符串转字节数组
    public String computeHexString(String str) {
        try {
            //用md5加密字符串
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] resultBytes = md5.digest(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder builder = new StringBuilder();
            for (byte b : resultBytes) {
                builder.append(byteToHexString(b));
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }
}
