package pl.wat.cinema.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.wat.cinema.entity.Person;
import pl.wat.cinema.service.PersonService;

import java.util.List;


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

    @PostMapping("persons/sign-up")
    public void signUp(@RequestBody Person person) {
        personService.signUp(person);
    }

}
