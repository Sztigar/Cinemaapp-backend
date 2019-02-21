package pl.wat.cinema.service;

import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Screening;
import pl.wat.cinema.repository.ScreeningRepository;

import java.util.List;

@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }


    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public Screening getScreening(Integer id) {
        return screeningRepository.getOne(id);
    }

    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public void updateScreening(Screening screening) {
        screeningRepository.save(screening);
    }
}
