package pl.wat.cinema.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.wat.cinema.dto.SeatsDto;
import pl.wat.cinema.entity.Person;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.entity.Seat;
import pl.wat.cinema.entity.Ticket;
import pl.wat.cinema.repository.PersonRepository;
import pl.wat.cinema.repository.ScreeningRepository;
import pl.wat.cinema.repository.SeatRepository;
import pl.wat.cinema.repository.TicketRepository;
import pl.wat.cinema.security.JWTAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private ScreeningRepository screeningRepository;
    private SeatRepository seatRepository;
    private JavaMailSender javaMailSender;
    private PersonRepository personRepository;


    public TicketService(TicketRepository ticketRepository, ScreeningRepository screeningRepository, SeatRepository seatRepository, JavaMailSender javaMailSender, PersonRepository personRepository) {
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.javaMailSender = javaMailSender;
        this.personRepository = personRepository;
    }

    public void addTicket(Ticket ticket) {
        Person person = personRepository.getOne(JWTAuthenticationFilter.getLogin());
        ticket.setLogin(person);
        ticketRepository.save(ticket);
        sendTicketInfo(ticket.getIdTicket());
    }

    public Ticket getTicket(Integer id) {
        return ticketRepository.getOne(id);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<SeatsDto> getTakenSeats(Integer id) {
        List<Ticket> ticketList = this.ticketRepository.findAll();
        List<Seat> seatList = (List<Seat>) screeningRepository.getOne(id).getIdHall().getSeatCollection();
        List<SeatsDto> seats = new ArrayList<>();
        for (Seat s : seatList) {
            seats.add(new SeatsDto(s.getIdSeat(), s.getPlace(), s.getRow(), false));
        }
        for (Ticket t : ticketList) {
            if (t.getIdScreening().getIdScreening().equals(id)) {
                Seat temp = t.getIdSeat();
                seats.add(seatList.indexOf(temp), new SeatsDto(temp.getIdSeat(), temp.getPlace(), temp.getRow(), true));
                seats.remove(new SeatsDto(temp.getIdSeat(), temp.getPlace(), temp.getRow(), false));
            }
        }
        return seats;
    }

    public void sendTicketInfo(Integer id) {
        StringBuilder emailText = new StringBuilder();
        Ticket ticket = ticketRepository.getOne(id);
        Screening screening = screeningRepository.getOne(ticket.getIdScreening().getIdScreening());
        Seat seat = seatRepository.getOne(ticket.getIdSeat().getIdSeat());
        emailText.append("Kupiłeś bilet do kina!\n")
                .append("Tytul: ").append(screening.getIdMovie().getTitle())
                .append("\nData: ").append(screening.getDate())
                .append("\nSala: ").append(screening.getIdHall().getIdHall())
                .append("\nRzad: ").append(seat.getRow())
                .append("\nMiejse: ").append(seat.getPlace())
                .append("\nCena: ").append(ticket.getPrice())
                .append("\nTen email uprawnia Cię do wstepu na film, wystarczy go pokazac pracownikom przy wejsciu.");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(ticketRepository.getOne(id).getLogin().getEmail());
        mail.setSubject("Bilet w MyCinema");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }


    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
    }
}
