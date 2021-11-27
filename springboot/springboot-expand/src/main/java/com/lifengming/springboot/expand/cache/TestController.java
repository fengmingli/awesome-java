package com.lifengming.springboot.expand.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifengming
 * @date 2020.08.08
 */
@RestController
public class TestController {
    @Autowired
    private Cache cache;


    @RequestMapping("/test/cache")
    public String test(@RequestParam(value = "appKey") String appKey) {
        System.out.println("start-one" + appKey);
        return cache.testOne(appKey);
    }
}
