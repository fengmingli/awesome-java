package com.lifengming.microservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lifengming
 * @date 2020.03.17
 */
@FeignClient(value = "microservice-one")
public interface TestClientService {
    /**
     * 获取id
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    void get();
}
