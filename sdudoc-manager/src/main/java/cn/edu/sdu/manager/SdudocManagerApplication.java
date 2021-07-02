package cn.edu.sdu.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.edu.sdu"})
public class SdudocManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdudocManagerApplication.class, args);
    }

}
