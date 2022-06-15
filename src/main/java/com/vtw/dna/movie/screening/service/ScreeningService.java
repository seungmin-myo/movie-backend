package com.vtw.dna.movie.screening.service;

import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.screening.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScreeningService {

    private ScreeningRepository repository;

    public ScreeningService(ScreeningRepository repository) {
        this.repository = repository;
    }

    public List<Screening> list(Long movieId) {
        if (movieId != null) {
            return repository.findAllByMovieId(movieId);
        } else {
            return repository.findAll();
        }
    }

    public Screening find(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Screening create(Screening newOne) {
        repository.save(newOne);
        return newOne;
    }

    public Screening update(Long id, Screening newOne) {
        Screening oldOne = repository.findById(id).orElseThrow();
        oldOne.update(newOne);
        repository.save(oldOne);
        return oldOne;
    }

    public Screening delete(Long id) {
        Screening oldOne = repository.findById(id).orElseThrow();
        repository.delete(oldOne);
        return oldOne;
    }

}
