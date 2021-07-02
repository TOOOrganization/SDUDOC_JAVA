package cn.edu.sdu.common.util;

import java.util.Base64;

public class Base64Util {

    public static String base64Encode2String(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
    public static String base64Encode2String(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    public static byte[] base64Encode2Bytes(String data) {
        return Base64.getEncoder().encode(data.getBytes());
    }
    public static byte[] base64Encode2Bytes(byte[] data) {
        return Base64.getEncoder().encode(data);
    }

    public static String base64Decode2String(String base64) {
        byte[] bytes = Base64.getDecoder().decode(base64.getBytes());
        return new String(bytes);
    }
    public static String base64Decode2String(byte[] base64) {
        byte[] bytes = Base64.getDecoder().decode(base64);
        return new String(bytes);
    }
    public static byte[] base64Decode2Bytes(String base64) {
        return Base64.getDecoder().decode(base64.getBytes());
    }
    public static byte[] base64Decode2Bytes(byte[] base64) {
        return Base64.getDecoder().decode(base64);
    }
}