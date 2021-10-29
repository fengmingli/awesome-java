package com.lifengming.springboot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lifengming
 * @date 2020.02.13
 */
@RestController
@RequestMapping
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello,From Docker!";
    }
}
