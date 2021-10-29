package com.lifengming.multi.datasource.service;

import com.lifengming.multi.datasource.domain.UserInfo;

import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.05
 */
public interface UserInfoService {
    /**
     * User列表
     *
     * @return UserInfo集合
     */
    List<UserInfo> listAll();


    /**
     * 插入一个UserInfo
     *
     * @param userInfo userInfo
     * @return 返回值
     */
    int insert(UserInfo userInfo);
}
