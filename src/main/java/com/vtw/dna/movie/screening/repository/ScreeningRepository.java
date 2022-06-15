package com.vtw.dna.movie.screening.repository;

import com.vtw.dna.movie.screening.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findAllByMovieId(Long movieId);

}
