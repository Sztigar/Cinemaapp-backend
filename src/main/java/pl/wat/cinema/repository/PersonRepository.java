package pl.wat.cinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wat.cinema.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
