package pl.wat.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.cinema.entity.Movie;
import pl.wat.cinema.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {


    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
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
}
