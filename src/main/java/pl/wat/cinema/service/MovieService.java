package pl.wat.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Movie;
import pl.wat.cinema.repository.MovieRepository;
import pl.wat.cinema.repository.TicketRepository;

import java.util.List;

@Service
public class MovieService {


    private MovieRepository movieRepository;
    private TicketRepository ticketRepository;

    public MovieService(MovieRepository movieRepository, TicketRepository ticketRepository){
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id) {
        return movieRepository.getOne(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) {
        ticketRepository.
        movieRepository.deleteById(id);
    }
}
