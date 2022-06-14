package com.vtw.dna.movie.screening.controller;

import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.screening.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningRepository repository;

    @GetMapping
    public List<Screening> list() {
        List<Screening> screenings = repository.findAll();
        return screenings;
    }

    @GetMapping("/{id}")
    public Screening find(@PathVariable Long id) {
        Screening screening = repository.findById(id).orElseThrow();
        return screening;
    }

    @PostMapping
    public Screening create(@RequestBody Screening newOne) {
        repository.save(newOne);
        return newOne;
    }

    @PutMapping("/{id}")
    public Screening update(@PathVariable Long id, @RequestBody Screening newOne) {
        Screening oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    @DeleteMapping("/{id}")
    public Screening delete(@PathVariable Long id) {
        Screening oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
