package cn.edu.sdu.sdudoc.sdudocdao.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangmin
 * @date 2018/8/15
 * @desc
 */
@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurationSupport {
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Admin API")
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private Predicate<String> paths() {
        return PathSelectors.regex("^/(?!error).*$");
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("BaiDu", "controller://baidu.com", " zhengja@dist.com.cn");
        return new ApiInfoBuilder()
                .title("个人SpringBoot测试系统")
                .description("开发API文档")
                .contact(contact)
                .version("1.0")
                .build();
    }

    /**
     * 解决swagger-ui.html 404无法访问的问题
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}