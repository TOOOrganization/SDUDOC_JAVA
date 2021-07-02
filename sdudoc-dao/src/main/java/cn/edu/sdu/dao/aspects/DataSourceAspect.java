package cn.edu.sdu.dao.aspects;

import cn.edu.sdu.dao.components.DynamicDataSource;
import cn.edu.sdu.dao.interfaces.TargetDataSource;
import cn.edu.sdu.dao.interfaces.DataSourceName;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAspect implements Ordered {

    private final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(cn.edu.sdu.dao.interfaces.TargetDataSource)")
    public void dataSourcePointCut() {}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        TargetDataSource ds = method.getAnnotation(TargetDataSource.class);

        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceName.SEARCH);
            logger.debug("use default data source: " + DataSourceName.SEARCH);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            logger.debug("switch data source to " + ds.name());
        }

        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clear data source");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
