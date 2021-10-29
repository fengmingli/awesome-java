package com.lifengming.server.starter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lifengming
 * @since 2020.02.02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//ServerAutoConfigMarker标记类
@Import(ServerAutoConfigMarker.class)
public @interface EnableRegisterServer {
}
