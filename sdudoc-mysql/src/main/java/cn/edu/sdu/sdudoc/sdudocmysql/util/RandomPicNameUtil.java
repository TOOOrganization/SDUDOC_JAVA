package cn.edu.sdu.sdudoc.sdudocmysql.util;

import java.util.UUID;

public class RandomPicNameUtil {

    public static String getRandomName(String fileName){
        int index = fileName.lastIndexOf(".");
        String prefix = fileName.substring(index);

        return UUID.randomUUID().toString().replace("-","") + prefix;
    }

    public static void main(String[] args) {
        System.out.println(getRandomName("aaa.jpg"));
        System.out.println(getRandomName("aaa.jpg"));
    }
}
