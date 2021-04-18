package cn.edu.sdu.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {

    public static String base64Encode(String plainTxt) {
        byte[] bytes = Base64.getEncoder().encode(plainTxt.getBytes(StandardCharsets.UTF_8));
        String secureTxt = new String(bytes);
        System.out.println(secureTxt);
        return secureTxt;
    }

    public static String base64Decode(String secureTxt) {
        byte[] bytes = Base64.getDecoder().decode(secureTxt.getBytes(StandardCharsets.UTF_8));
        return new String(bytes);
    }
}