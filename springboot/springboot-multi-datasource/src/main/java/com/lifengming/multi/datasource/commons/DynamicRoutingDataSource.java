package com.lifengming.multi.datasource.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源（需要继承AbstractRoutingDataSource）
 * 实现读写分离的核心
 * <P>
 *
 * @author lifengming
 * @date 2020.02.05
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源：{}", DynamicDataSourceContextHolder.getDataSource());
        return DynamicDataSourceContextHolder.getDataSource();
    }
}
