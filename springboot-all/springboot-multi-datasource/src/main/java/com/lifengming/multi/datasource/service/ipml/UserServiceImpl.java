package com.lifengming.multi.datasource.service.ipml;

import com.lifengming.multi.datasource.annotation.TargetDataSource;
import com.lifengming.multi.datasource.commons.DataSourceKey;
import com.lifengming.multi.datasource.domain.User;
import com.lifengming.multi.datasource.mapper.UserMapper;
import com.lifengming.multi.datasource.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_OTHER)
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
