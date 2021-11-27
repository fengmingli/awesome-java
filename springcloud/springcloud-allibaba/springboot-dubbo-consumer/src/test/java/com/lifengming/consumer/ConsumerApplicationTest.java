package com.lifengming.consumer;

import com.lifengming.client.TicketService;
import com.lifengming.consumer.service.UserService;
import com.lifengming.client.TicketDTO;
import com.lifengming.consumer.service.UserService2;
import javafx.beans.binding.When;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author lifengming
 * @since 2020.01.31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplicationWebTest.class)
//@TestExecutionListeners({MyBeanPostProcessor.class,})
public class ConsumerApplicationTest {


    @Autowired
    UserService userService;

    @Autowired
    UserService2 userService2;

    @Reference(check = false)
    TicketService ticketService;

    @Autowired
    ApplicationContext applicationContext;


//    @Before
//    public void before() {
////        ConsumerApplicationTest myApi = applicationContext.getBean(ConsumerApplicationTest.class);
//        TicketService fromSpring = applicationContext.getBean(TicketService.class);
//    }

    @Test
    public void contextLoads() {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setAge(1);
        userService.bugTicket(ticketDTO);

    }

    @Test
    public void mockTest(){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setAge(1);

        when(ticketService.getTicket(ticketDTO)).thenReturn("-》测试成功");
        String mock = userService.mock(ticketDTO);
        userService2.bugTicket(ticketDTO);


        System.out.println(mock);
    }



}
