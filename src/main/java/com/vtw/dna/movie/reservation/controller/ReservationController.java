package com.vtw.dna.movie.reservation.controller;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.reservation.Reservation;
import com.vtw.dna.movie.reservation.repository.ReservationRepository;
import com.vtw.dna.movie.reservation.service.ReservationService;
import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;
    private final MovieService movieService;

    @GetMapping
    public List<Reservation> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Reservation find(@PathVariable Long id) {
        return service.find(id);

    }

    @PostMapping
    public Reservation create(@RequestBody Reservation newOne) {
        return service.create(newOne);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation newOne) {
        return service.update(id, newOne);
    }

    @DeleteMapping("/{id}")
    public Reservation delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PostMapping("/calculateFee")
    public Reservation calculateFee(@RequestBody Reservation newOne) {
        Screening screening = newOne.getScreening();
//        Long movieId = screening.getMovie().getId();
//        Movie movie = movieService.find(movieId);
//        newOne.getScreening().setMovie(movie);
        Reservation reservation = screening.reserve(newOne.getCustomerName(), newOne.getAudienceCount());
        return reservation;
    }

}
