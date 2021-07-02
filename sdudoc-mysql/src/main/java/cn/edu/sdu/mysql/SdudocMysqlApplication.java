package cn.edu.sdu.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"cn.edu.sdu"})
public class SdudocMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdudocMysqlApplication.class, args);
    }

}
