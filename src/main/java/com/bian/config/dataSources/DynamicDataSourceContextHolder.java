package com.bian.config.dataSources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<String> dataSourceIds = new ArrayList<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String    getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType(){
        contextHolder.remove();
    }

    public static boolean containsDataSource(String dataSouceId) {
        return dataSouceId.contains(dataSouceId);
    }
}
