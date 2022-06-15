package com.vtw.dna.movie.screening.controller;

import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.screening.repository.ScreeningRepository;
import com.vtw.dna.movie.screening.service.ScreeningService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningService service;

    @GetMapping
    public List<Screening> list(Long movieId) {
        return service.list(movieId);
    }

    @GetMapping("/{id}")
    public Screening find(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    public Screening create(@RequestBody Screening newOne) {
        return service.create(newOne);
    }

    @PutMapping("/{id}")
    public Screening update(@PathVariable Long id, @RequestBody Screening newOne) {
        return service.update(id, newOne);
    }

    @DeleteMapping("/{id}")
    public Screening delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
