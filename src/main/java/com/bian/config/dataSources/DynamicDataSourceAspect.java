package com.bian.config.dataSources;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Created by Mr.Bi on 2017/3/1.
 */
@Aspect
@Order(-1)  //要在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource dataSource) {
        String dsId = dataSource.name();
        if (!DynamicDataSourceContextHolder.dataSourceIds.contains(dsId)) {
            //使用默认数据源
        } else {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.name());
        }
    }

    @After("@annotation(dataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource dataSource) {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

//    EmptyInterceptor
}
