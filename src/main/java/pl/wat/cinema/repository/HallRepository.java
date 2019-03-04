package pl.wat.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.cinema.entity.Seat;

public interface HallService extends JpaRepository<Integer, Seat> {
}
