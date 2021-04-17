package cn.edu.sdu.sdudoc.sdudocmysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages ={"cn.edu.sdu.sdudoc.sdudocdao.repository"})
@SpringBootApplication
//./../../../sdudoc-dao/src/main/java/cn/edu/sdu/sdudoc/sdudocdao/mapper
public class SdudocMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdudocMysqlApplication.class, args);
    }

}
