package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.discount.condition.PeriodCondition;
import com.vtw.dna.movie.discount.condition.SequenceCondition;
import com.vtw.dna.movie.discount.policy.AmountDiscountPolicy;
import com.vtw.dna.movie.discount.policy.NoneDiscountPolicy;
import com.vtw.dna.movie.discount.policy.PercentDiscountPolicy;
import com.vtw.dna.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;

    @GetMapping
    public List<Movie> list() {
        List<Movie> movies = repository.findAll();
        return movies;
    }

    @GetMapping("/{id}")
    public Movie find(@PathVariable Long id) {
        Movie movie = repository.findById(id).orElseThrow();
        return movie;
    }

    @PostMapping
    public Movie create(@RequestBody Movie newOne) {
        repository.save(newOne);
        return newOne;
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie newOne) {
        Movie oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id) {
        Movie oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
