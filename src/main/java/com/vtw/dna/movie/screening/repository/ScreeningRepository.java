package com.vtw.dna.movie.screening.repository;

import com.vtw.dna.movie.screening.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
