package com.lifengming.springboot.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Value(value = "${username:null}")
    private String myName;
    @Value(value = "${age:null}")
    private String project;

    @GetMapping(value = "/info")
    public String info () {
        return myName+":"+project;
    }

}
