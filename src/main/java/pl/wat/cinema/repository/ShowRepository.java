package pl.wat.cinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.cinema.entity.Screening;

@Repository
public interface ShowRepository extends JpaRepository<Screening,Integer> {

}
