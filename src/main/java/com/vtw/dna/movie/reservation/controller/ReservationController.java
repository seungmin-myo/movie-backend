package com.vtw.dna.movie.reservation.controller;

import com.vtw.dna.movie.reservation.Reservation;
import com.vtw.dna.movie.reservation.repository.ReservationRepository;
import com.vtw.dna.movie.screening.Screening;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository repository;

    @GetMapping
    public List<Reservation> list() {
        List<Reservation> reservations = repository.findAll();
        return reservations;
    }

    @GetMapping("/{id}")
    public Reservation find(@PathVariable Long id) {
        Reservation reservation = repository.findById(id).orElseThrow();
        return reservation;
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation newOne) {
        Screening screening = newOne.getScreening();
        Reservation reservation = screening.reserve(newOne.getCustomerName(), newOne.getAudienceCount());
        repository.save(reservation);
        return newOne;
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation newOne) {
        Reservation oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    @DeleteMapping("/{id}")
    public Reservation delete(@PathVariable Long id) {
        Reservation oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
