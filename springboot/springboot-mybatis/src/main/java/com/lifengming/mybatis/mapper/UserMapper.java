package com.lifengming.mybatis.mapper;

import com.lifengming.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lifengming
 * @since 2019.12.17
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有的User 列表
     *
     * @return List<User>
     */
    @Select("select * from user")
    List<User> list();
}
