package com.lifengming.multi.datasource.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lifengming
 * @date 2020.02.05
 */
@Setter
@Getter
public class User {
    private int id;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
}
