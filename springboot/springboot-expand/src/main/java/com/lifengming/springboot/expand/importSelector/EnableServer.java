package com.lifengming.springboot.expand.importSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lifengming
 * @date 2020.12.06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportSelector.class)
//@Import(ServerImportBeanBeanDefinitionRegister.class)
public @interface EnableServer {

    /**
     * 设置服务器类型
     * @return non-null
     */
    Server.Type type();
}
