package pl.wat.cinema.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.wat.cinema.entity.Person;
import pl.wat.cinema.service.PersonService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonController {


    private PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/persons/{login}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable String login) {
        return ResponseEntity.ok(personService.getPerson(login));
    }

    @RequestMapping(value = "/persons/{login}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable String login) {
        personService.deletePerson(login);
        return ResponseEntity.ok().header("Access-Control-Allow-Origin : *").build();
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/persons", method = RequestMethod.PUT)
    public ResponseEntity updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/persons/sign-up", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody Person person) {
        try {
            personService.signUp(person);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
