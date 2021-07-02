package cn.edu.sdu.dao.config;

import cn.edu.sdu.dao.interfaces.DataSourceName;
import cn.edu.sdu.dao.components.DynamicDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseDynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.editor")
    public DataSource editorDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.search")
    public DataSource searchDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource editorDataSource,
                                        DataSource searchDataSource,
                                        DataSource mysqlDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);

        targetDataSources.put(DataSourceName.EDITOR, editorDataSource);
        targetDataSources.put(DataSourceName.SEARCH, searchDataSource);
        targetDataSources.put(DataSourceName.MYSQL, mysqlDataSource);

        return new DynamicDataSource(searchDataSource, targetDataSources);
    }
}
