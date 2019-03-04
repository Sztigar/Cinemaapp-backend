package pl.wat.cinema.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Person;
import pl.wat.cinema.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {


    private PersonRepository personRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JavaMailSender javaMailSender;

    public PersonService(PersonRepository personRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JavaMailSender javaMailSender) {
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.javaMailSender = javaMailSender;
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

    public void signUp(Person person) throws Exception {
        Optional<Person> test = personRepository.findById(person.getLogin());
        if (test.isPresent()) {
            throw new Exception("Duplicate");
        } else {
            person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
            personRepository.save(person);

        }
    }

    private void sendRegisterInfo(Person person) {
        StringBuilder emailText = new StringBuilder();
        emailText.append("Witam w moim kinie!\n")
                .append("Twoj login to: ")
                .append(person.getLogin()).append("\nTwoje haslo to: ")
                .append(person.getPassword())
                .append("\nMożesz teraz przeglądać repertuar i kupić bilet.\n")
                .append("Zyczmy miłego seansu.\n");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(person.getEmail());
        mail.setSubject("Rejestracja w MyCinema");
        mail.setText(emailText.toString());
        javaMailSender.send(mail);
    }

    public void deletePerson(String login) {
        this.personRepository.deleteById(login);
    }
}
