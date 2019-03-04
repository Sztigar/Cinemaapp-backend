package pl.wat.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.cinema.entity.Hall;
import pl.wat.cinema.entity.Seat;

public interface HallRepository extends JpaRepository<Hall, Integer> {
}
