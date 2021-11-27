package com.lifengming.multi.datasource.mapper;

import com.lifengming.multi.datasource.domain.User;

import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.05
 */
public interface UserMapper {

    /**
     * User列表
     *
     * @return User集合
     */
    List<User> listAll();

    /**
     * 插入一个User
     *
     * @param user user
     * @return int
     */
    int insert(User user);
}
