package io.lushangyan.springrouting.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 *
 * @author lushangyan
 * @version V1.0.0
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(io.lushangyan.springrouting.datasource.CurDataSource)")
    public void dataSourcePointCut() {

    }




    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.DB0);
            System.out.println("set datasource is " + DataSourceNames.DB0);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            System.out.println("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            System.out.println("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }


}
