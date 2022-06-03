package com.vtw.dna.movie.reservation.repository;

import com.vtw.dna.movie.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
