package com.lifengming.multi.datasource;


import com.lifengming.multi.datasource.domain.User;
import com.lifengming.multi.datasource.domain.UserInfo;
import com.lifengming.multi.datasource.service.UserInfoService;
import com.lifengming.multi.datasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


/**
 * @author lifengming
 * @date 2020.02.05
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisConfigTest {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @org.junit.Test
    public void Test() {
        for (int i = 1; i < 100000; i++) {
            User user = new User();
            user.setUsername("lfm"+i);
            user.setPassword("lfm"+i);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());

//            UserInfo userInfo = new UserInfo();
//            userInfo.setName("mvv"+i);
//            userInfo.setEmail("mvv@mvv.com");

            log.info("user表写入结果：" + userService.insert(user));
//            log.info("user_info写入结果：" + userInfoService.insert(userInfo));
        }
    }
}
