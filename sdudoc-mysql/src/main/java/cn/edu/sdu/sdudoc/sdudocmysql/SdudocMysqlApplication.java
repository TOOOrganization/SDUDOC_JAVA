package cn.edu.sdu.sdudoc.sdudocmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackages = {"cn.edu.sdu.sdudoc.sdudocmbg.repository", "cn.edu.sdu.sdudoc.sdudocmbg."})
@EnableJpaRepositories(basePackages = "cn.edu.sdu.sdudoc.sdudocmbg.repository")
@EntityScan(basePackages = "cn.edu.sdu.sdudoc.sdudocmbg.entity")
@SpringBootApplication
public class SdudocMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdudocMysqlApplication.class, args);
    }

}
