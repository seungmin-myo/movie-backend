package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @GetMapping
    public List<Movie> list() {
        List<Movie> movies = service.list();
        return movies;
    }

    @GetMapping("/{id}")
    public Movie find(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie newOne) {
        return service.create(newOne);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie newOne) {
        return service.update(id, newOne);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
