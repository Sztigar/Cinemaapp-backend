package pl.wat.cinema.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.cinema.entity.Hall;
import pl.wat.cinema.service.HallService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HallController {

    private HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @RequestMapping("/hall/{id}")
    public ResponseEntity<Hall> getHall(@PathVariable Integer id){
        return ResponseEntity.ok(hallService.getHall(id));
    }
}
