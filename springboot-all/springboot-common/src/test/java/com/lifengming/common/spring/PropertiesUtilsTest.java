package com.lifengming.common.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author lifengming
 * @since 2019.12.31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesUtilsTest {

    @Autowired
    PropertiesUtils propertiesUtils;


    @Test
    public void getPropertiesValue() {
        System.out.println(propertiesUtils.getPropertiesValue("a.b.c"));
    }
}
