package pl.wat.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.cinema.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
