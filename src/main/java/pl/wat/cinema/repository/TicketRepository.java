package pl.wat.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    public List<Ticket> findAllByIdScreening(Integer id);
}
