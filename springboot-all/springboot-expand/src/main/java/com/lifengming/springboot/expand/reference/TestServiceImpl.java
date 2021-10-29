package com.lifengming.springboot.expand.reference;

import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2020.06.04
 */
@Component
public class TestServiceImpl implements TestService {


    @Override
    public void addStudent(Student student) {
        student.setAge(11);
        student.setName("LFM");

        System.out.println("TestServiceImpl implements TestService");
    }
}
