package pl.wat.cinema.service;

import org.springframework.stereotype.Service;
import pl.wat.cinema.dto.SeatsDto;
import pl.wat.cinema.dto.TakenSeatsListDto;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.entity.Seat;
import pl.wat.cinema.entity.Ticket;
import pl.wat.cinema.repository.ScreeningRepository;
import pl.wat.cinema.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<SeatsDto> getTakenSeats(Integer id) {
        List<Ticket> ticketList = this.ticketRepository.findAll();
        List<Seat> seatList = (List<Seat>) screeningRepository.getOne(id).getIdHall().getSeatCollection();
        List<SeatsDto> seats = new ArrayList<>();
        List<TakenSeatsListDto> rowsOfSeats = new ArrayList<>();
        Integer numberOfRows = seatList.get(seatList.size()).getRow();

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
        int i = 1;
        while(i < numberOfRows){
            for(int j = 0; j < seatList.size(); j++){
                List<SeatsDto> seatsInRow 
            }
            rowsOfSeats.add(i, )
        }


        return seats;
    }
}
