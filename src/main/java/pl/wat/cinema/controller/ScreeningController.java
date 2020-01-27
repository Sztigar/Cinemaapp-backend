package pl.wat.cinema.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wat.cinema.dto.SeatsDto;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.service.ScreeningService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ScreeningController {

    private ScreeningService screeningService;


    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }


    @RequestMapping(value = "/screenings", method = RequestMethod.GET)
    public List<Screening> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @RequestMapping(value = "/screenings/{id}", method = RequestMethod.GET)
    public ResponseEntity<Screening> getScreening(@PathVariable Integer id) {
        return ResponseEntity.ok(screeningService.getScreening(id));
    }

    @RequestMapping(value = "/screenings", method = RequestMethod.POST)
    public ResponseEntity addScreening(@RequestBody Screening screening) {
        screeningService.addScreening(screening);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/screenings", method = RequestMethod.PUT)
    public ResponseEntity updateScreening(@RequestBody Screening screening) {
        screeningService.updateScreening(screening);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/screenings/{id}/seats", method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, List<SeatsDto>>> getTakenSeats(@PathVariable Integer id) {
        return ResponseEntity.ok(screeningService.getTakenSeats(id));
    }


}
