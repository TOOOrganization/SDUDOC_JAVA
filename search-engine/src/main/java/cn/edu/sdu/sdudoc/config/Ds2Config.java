package cn.edu.sdu.sdudoc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * 第一个数据源，jpa的相关配置
 */
@Configuration
@EntityScan(basePackages = "cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2")
//1、实体扫描
//2、实体管理ref
//3、事务管理
@EnableJpaRepositories(
        basePackages = "cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2",
        entityManagerFactoryRef = "ds2EntityManagerFactoryBean",
        transactionManagerRef = "ds2TransactionManager")
@EnableTransactionManagement
public class Ds2Config {

    //第一个数据源，可以不加Qualifier
    @Autowired
    @Qualifier("ds2DataSource")
    private DataSource dataSource;

    //jpa其他参数配置
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    //实体管理工厂builder
    @Autowired
    private EntityManagerFactoryBuilder factoryBuilder;

    /**
     * 配置第一个实体管理工厂的bean
     */
    @Bean(name = "ds2EntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        return factoryBuilder.dataSource(dataSource)
                //这一行的目的是加入jpa的其他配置参数比如（ddl-auto: update等）
                //当然这个参数配置可以在事务配置的时候也可以
                .properties(hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings()))
                .packages("cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2")
                .persistenceUnit("ds2PersistenceUnit")
                .build();
    }

    /**
     * EntityManager
     */
    @Bean(name = "ds2EntityManager")
    public EntityManager entityManager() {
        return Objects.requireNonNull(entityManagerFactoryBean().getObject()).createEntityManager();
    }

    /**
     * jpa事务管理
     */
    @Bean(name = "ds2TransactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
}