package com.vtw.dna.screening;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.reservation.Reservation;
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


    public Reservation reserve(String name, int audienceCount) {
        return new Reservation(name, this, audienceCount, audienceCount);
    }

}
