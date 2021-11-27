package com.lifengming.multi.datasource.service.ipml;

import com.lifengming.multi.datasource.annotation.TargetDataSource;
import com.lifengming.multi.datasource.commons.DataSourceKey;
import com.lifengming.multi.datasource.domain.UserInfo;
import com.lifengming.multi.datasource.mapper.UserInfoMapper;
import com.lifengming.multi.datasource.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.05
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE2)
    public List<UserInfo> listAll() {
        return userInfoMapper.listAll();
    }

    @Override
    @TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }
}
