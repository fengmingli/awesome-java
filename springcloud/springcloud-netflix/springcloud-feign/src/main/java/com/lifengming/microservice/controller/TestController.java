package com.lifengming.microservice.controller;

import com.lifengming.microservice.feign.TestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifengming
 * @date 2020.03.17
 */
@RestController
public class TestController {
    private final TestClientService testClientService;

    @Autowired
    public TestController(TestClientService testClientService) {
        this.testClientService = testClientService;
    }

    @RequestMapping("/test")
    public void test() {
        testClientService.get();
    }
}
