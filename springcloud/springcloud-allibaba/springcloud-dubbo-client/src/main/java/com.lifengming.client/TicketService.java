package com.lifengming.client;


import javax.validation.Valid;

/**
 * @author lifengming
 * @since 2020.01.31
 */
public interface TicketService {
    /**
     *
     * @return
     */
     String getTicket(@Valid TicketDTO ticketDTO);
}
