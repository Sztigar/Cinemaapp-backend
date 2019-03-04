package pl.wat.cinema.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wat.cinema.dto.SeatsDto;
import pl.wat.cinema.entity.Ticket;
import pl.wat.cinema.service.TicketService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicket(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.getTicket(id));
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTicket(@PathVariable Integer id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().header("Access-Control-Allow-Origin : *").build();
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public ResponseEntity addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.PUT)
    public ResponseEntity updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/seats/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<SeatsDto>> getTakenSeats(@PathVariable Integer id) {
        return ResponseEntity.ok(ticketService.getTakenSeats(id));
    }

}
