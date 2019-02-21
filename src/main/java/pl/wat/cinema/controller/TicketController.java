package pl.wat.cinema.controller;


import org.springframework.web.bind.annotation.RestController;
import pl.wat.cinema.repository.TicketRepository;

@RestController
public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }



}
