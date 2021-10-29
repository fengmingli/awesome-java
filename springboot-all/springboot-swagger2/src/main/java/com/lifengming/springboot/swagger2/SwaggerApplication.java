package com.lifengming.springboot.swagger2;

import com.lifengming.springboot.swagger2.infrastructure.CompanyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lifengming
 * @date 2020.02.28
 */
@SpringBootApplication
@MapperScan(basePackageClasses= CompanyMapper.class)
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class,args);
    }
}
