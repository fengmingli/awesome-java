package com.lifengming.aop.annotation;

import java.lang.annotation.*;

/**
 * @author lifengming
 * @since 2019.12.20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AopLog {
}
