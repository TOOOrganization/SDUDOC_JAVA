package cn.edu.sdu.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"cn.edu.sdu"})
public class SdudocDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdudocDaoApplication.class, args);
    }

}
