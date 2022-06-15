package com.vtw.dna.movie.service;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.screening.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieService {

    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> list() {
            return repository.findAll();
    }

    public Movie find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Movie create(Movie newOne) {
        repository.save(newOne);
        return newOne;
    }

    public Movie update(Long id, Movie newOne) {
        Movie oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    public Movie delete(Long id) {
        Movie oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
