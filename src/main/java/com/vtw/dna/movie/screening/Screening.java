package com.vtw.dna.movie.screening;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.reservation.Reservation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Reservation reserve(String name, int audienceCount) {
        return new Reservation(name, this, calculateFee(audienceCount), audienceCount);
    }



}
