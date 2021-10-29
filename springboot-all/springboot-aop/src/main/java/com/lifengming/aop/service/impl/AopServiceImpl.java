package com.lifengming.aop.service.impl;

import com.lifengming.aop.annotation.AopLog;
import com.lifengming.aop.service.AopService;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @since 2019.12.20
 */
@Component
public class AopServiceImpl implements AopService {

    @AopLog
    @Override
    public void test() {
        System.out.println("测试通过");
    }

    @Override
    @AopLog
    public  void setOne(){
        System.out.println("setOne");
    }

    @Override
    public void setTwo() {
        System.out.println("xxx");
    }
}
