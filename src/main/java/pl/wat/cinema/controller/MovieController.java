package pl.wat.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wat.cinema.entity.Movie;
import pl.wat.cinema.service.MovieService;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/movies", method = RequestMethod.PUT)
    public ResponseEntity updateMovie(@RequestBody Movie movie){
        movieService.updateMovie(movie);
        return ResponseEntity.ok().build();
    }

}
