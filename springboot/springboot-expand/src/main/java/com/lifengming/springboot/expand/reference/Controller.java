package com.lifengming.springboot.expand.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.06.04
 */
@Component
public class Controller implements CommandLineRunner {
    @Autowired
    TestService testService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Controller implements CommandLineRunner");
        Student student = new Student();
        testService.addStudent(student);
        System.out.println(student.toString());
    }
}
