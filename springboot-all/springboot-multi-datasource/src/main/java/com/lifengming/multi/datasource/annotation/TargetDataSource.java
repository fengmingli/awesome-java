package com.lifengming.multi.datasource.annotation;

import com.lifengming.multi.datasource.commons.DataSourceKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 动态数据源的切点
 *
 * @author lifengming
 * @date 2020.02.05
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    DataSourceKey dataSourceKey() default DataSourceKey.DB_MASTER;
}
