package com.lifengming.springboot.expand.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lifengming
 * @date 2020.08.08
 */
@Service

public class CacheImpl implements Cache {
    @Resource
    CacheController cacheController;

    Map<String,String> map=new ConcurrentHashMap<>();

    @Override
    @Cacheable(value = "appInfo", key = "'appInfo_'+#appKey")
    public String testOne(String appKey) {
        System.out.println("start-two" + appKey);
        return cacheController.dataGet(appKey);
    }
}
