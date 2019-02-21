package pl.wat.cinema.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.cinema.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
