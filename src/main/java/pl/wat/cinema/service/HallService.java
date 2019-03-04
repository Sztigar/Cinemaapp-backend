package pl.wat.cinema.service;


import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Hall;
import pl.wat.cinema.repository.HallRepository;

@Service
public class HallService {

    private HallRepository hallRepository;

    public HallService(HallRepository hallRepository){
        this.hallRepository = hallRepository;
    }

    public Hall getHall(Integer id) {
        return hallRepository.getOne(id);
    }
}
