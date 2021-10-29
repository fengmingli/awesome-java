package com.lifengming.multi.datasource.commons;

import com.lifengming.multi.datasource.annotation.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 通过切面实现不同数据库之间的操作
 * <p>
 * Order(-1) //保证该AOP在@Transactional前全部执行
 *
 * @author lifengming
 * @date 2020.02.05
 * @see com.lifengming.multi.datasource.annotation.TargetDataSource
 */


@Order(-1)
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    /**
     * 定义一个切点
     */
    @Pointcut("execution(* com.lifengming.multi.datasource.service.*.list.*(..))")
    public void pointCut() {
        //no op
    }

    /**
     * 执行方法前更换数据源
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @Before("@annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        DataSourceKey dataSourceKey = targetDataSource.dataSourceKey();
        if (dataSourceKey == DataSourceKey.DB_OTHER) {
            log.info(String.format("设置数据源为  %s", DataSourceKey.DB_OTHER));
            DynamicDataSourceContextHolder.setDataSourceByKey(DataSourceKey.DB_OTHER);
        } else {
            log.info(String.format("使用默认数据源  %s", DataSourceKey.DB_MASTER));
            DynamicDataSourceContextHolder.setDataSourceByKey(DataSourceKey.DB_MASTER);
        }
    }

    /**
     * 执行并且保存
     *
     * @param joinPoint 连接点
     */
    @Before(value = "pointCut()")
    public void doBeforeWithSlave(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取当前切点方法对象
        Method method = methodSignature.getMethod();
        //判断是否为借口方法
        if (method.getDeclaringClass().isInterface()) {
            try {
                //获取实际类型的方法对象
                method = joinPoint.getTarget().getClass()
                        .getDeclaredMethod(joinPoint.getSignature().getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
                log.error("方法不存在！", e);
            }
        }
        if (null == method.getAnnotation(TargetDataSource.class)) {
            DynamicDataSourceContextHolder.setSlave();
        }
    }


    /**
     * 执行方法后清除数据源设置
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        log.info(String.format("当前数据源  %s  执行清理方法", targetDataSource.dataSourceKey()));
        DynamicDataSourceContextHolder.clearDataSource();
    }
}
