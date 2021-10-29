package com.lifengming.aop.service.impl;

import com.lifengming.aop.App;
import com.lifengming.aop.service.AopService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author lifengming
 * @since 2019.12.20
 */
@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class AopServiceImplTest {
    @Autowired
    AopService aopService;

    @org.junit.Test
    public void test1() {
        aopService.setOne();
        aopService.setTwo();
    }
}