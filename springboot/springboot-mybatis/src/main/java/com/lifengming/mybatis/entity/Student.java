package com.lifengming.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lifengming
 * @since 2019.12.16
 */
@Setter
@Getter
@ToString
public class Student {
    /**学号*/
    private Integer id;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;

    /**班级*/
    private String className;
}
