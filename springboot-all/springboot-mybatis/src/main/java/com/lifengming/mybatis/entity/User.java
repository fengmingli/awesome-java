package com.lifengming.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lifengming
 * @since 2019.12.17
 */
@Setter
@Getter
public class User {
    /**id*/
    private Integer id;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;
}
