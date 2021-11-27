package com.lifengming.provider.service.impl;

import com.lifengming.client.TicketDTO;
import com.lifengming.client.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @since 2020.01.31
 */
@Service(timeout = 3000, interfaceClass = TicketService.class, validation = "true")
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket(TicketDTO ticketDTO) {

        return ticketDTO.toString();
    }
}
