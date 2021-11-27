package com.lifengming.consumer.service;


import com.lifengming.client.TicketDTO;
import com.lifengming.client.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lifengming
 * @since 2020.01.31
 */
@Service
public class UserService implements User {


    /**
     * 远程引用指定的服务，他会按照全类名进行匹配，看谁给注册中心注册了这个全类名
     */
    @Reference(check = false)
    TicketService ticketService;

    public void bugTicket(TicketDTO ticketDTO) {
        String ticket = this.ticketService.getTicket(ticketDTO);
        System.out.println("在注册中心买到" + ticket);
    }

    @Override
    public String mock(TicketDTO ticketDTO) {
       return ticketService.getTicket(ticketDTO);
    }
}
