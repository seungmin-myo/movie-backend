package com.vtw.dna.movie.reservation.service;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.movie.reservation.Reservation;
import com.vtw.dna.movie.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> list() {
            return repository.findAll();
    }

    public Reservation find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Reservation create(Reservation newOne) {
        repository.save(newOne);
        return newOne;
    }

    public Reservation update(Long id, Reservation newOne) {
        Reservation oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    public Reservation delete(Long id) {
        Reservation oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
