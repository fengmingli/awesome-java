package com.lifengming.springboot.expand.reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lifengming
 * @date 2020.06.04
 */
@SpringBootApplication
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
        System.out.println("MAIN");
    }
}
/**
 * 2020-08-16 22:47:05.048  INFO 2796 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 *  Listener
 * 2020-08-16 22:47:05.058  INFO 2796 --- [           main] c.l.springboot.expand.reference.Test     : Started Test in 2.214 seconds (JVM running for 3.472)
 * Controller implements CommandLineRunner
 * TestServiceImpl implements TestService
 * Student{name='LFM', age=11, sex='null'}
 * MAIN
 *
 */

