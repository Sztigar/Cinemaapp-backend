package pl.wat.cinema.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Person;
import pl.wat.cinema.repository.PersonRepository;

import java.util.List;


@Service
public class PersonService {


    private PersonRepository personRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PersonService(PersonRepository personRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(String login) {
        return personRepository.getOne(login);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void signUp(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }
}
