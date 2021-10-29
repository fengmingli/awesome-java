package com.lifengming.springboot.expand.cache;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lifengming
 * @date 2020.08.08
 */
@Component
public class CacheController {

    Map<String, String> appInfo = new HashMap<>();

    public String dataGet(String appKey) {
        System.out.println("rpc:" + appKey);
        return appInfo.get(appKey);
    }

    @PostConstruct
    public void init() {
        appInfo.put("one", "11111111");
        appInfo.put("two", "22222222");
        appInfo.put("three", "3333333");
        appInfo.put("four", "4444444");
        appInfo.put("five", "555555");
    }



}
