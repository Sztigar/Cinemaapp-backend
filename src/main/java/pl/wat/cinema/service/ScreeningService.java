package pl.wat.cinema.service;

import org.springframework.stereotype.Service;
import pl.wat.cinema.dto.SeatsDto;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.entity.Seat;
import pl.wat.cinema.entity.Ticket;
import pl.wat.cinema.repository.ScreeningRepository;
import pl.wat.cinema.repository.TicketRepository;

import java.util.*;

@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;
    private TicketRepository ticketRepository;

    public ScreeningService(ScreeningRepository screeningRepository, TicketRepository ticketRepository) {
        this.screeningRepository = screeningRepository;
        this.ticketRepository = ticketRepository;
    }


    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public Screening getScreening(Integer id) {
        return screeningRepository.getOne(id);
    }

    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public void updateScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public Map<Integer, List<SeatsDto>> getTakenSeats(Integer id) {
        List<Ticket> ticketList = this.ticketRepository.findAll();
        List<Seat> seatList = (List<Seat>) screeningRepository.getOne(id).getIdHall().getSeatCollection();
        Map<Integer, List<SeatsDto>> seatsMap = new HashMap<>();
        for (Seat s : seatList) {
            seatsMap.computeIfAbsent(s.getRow(), k -> new ArrayList<>()).add(new SeatsDto(s.getIdSeat(), s.getPlace(), s.getRow(), false));
        }
        for (Ticket t : ticketList) {
            if (t.getIdScreening().getIdScreening().equals(id)) {
                seatsMap.computeIfPresent(t.getIdSeat().getRow(), (k, val) -> {
                    Seat temp = t.getIdSeat();
                    val.add(new SeatsDto(temp.getIdSeat(), temp.getPlace(), temp.getRow(), true));
                    val.remove(new SeatsDto(temp.getIdSeat(), temp.getPlace(), temp.getRow(), false));
                    return val;
                });
            }
        }
        seatsMap.forEach((integer, seatsDtos) -> Collections.sort(seatsDtos));
        return seatsMap;

    }
}
