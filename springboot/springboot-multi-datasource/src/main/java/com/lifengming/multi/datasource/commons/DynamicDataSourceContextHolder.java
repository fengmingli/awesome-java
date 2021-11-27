package com.lifengming.multi.datasource.commons;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author lifengming
 * @date 2020.02.05
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceKey> CURRENT_DATASOURCE = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clearDataSource() {
        CURRENT_DATASOURCE.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey getDataSource() {
        return CURRENT_DATASOURCE.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void setDataSourceByKey(DataSourceKey value) {
        CURRENT_DATASOURCE.set(value);
    }

    /**
     * 设置从从库读取数据
     */
    public static void setSlave() {
        final int var1 = 2;
        if (RandomUtils.nextInt(0, var1) > 0) {
            DynamicDataSourceContextHolder.setDataSourceByKey(DataSourceKey.DB_SLAVE2);
        } else {
            DynamicDataSourceContextHolder.setDataSourceByKey(DataSourceKey.DB_SLAVE1);
        }
    }
}
