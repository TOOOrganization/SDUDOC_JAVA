package cn.edu.sdu.dao.interfaces;

import java.lang.annotation.*;

/**
 * 指定要使用的数据源
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name() default "";
}
