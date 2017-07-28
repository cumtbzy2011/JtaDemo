package com.bian.config.dataSources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        //返回数据源的key，spring选择数据源时依靠这个方法去context中寻找bean
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
