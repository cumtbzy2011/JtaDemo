package com.bian.config.dataSources;

import java.lang.annotation.*;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
