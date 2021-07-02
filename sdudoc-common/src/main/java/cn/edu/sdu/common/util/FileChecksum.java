package cn.edu.sdu.common.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

public class FileChecksum {

    public static String checksumSHA256(byte[] data) throws IOException {
        return DigestUtils.sha256Hex(data);
    }

    public static void main(String[] args) {

    }
}
