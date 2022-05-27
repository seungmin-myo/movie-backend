package com.vtw.dna.reservation;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.screening.Screening;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    private String customerName;
    private int audienceCount;
    private int calculateFee;


    public Reservation(String customerName, Screening screening, int audienceCount, int calculateFee) {
        this.customerName = customerName;
        this.screening = screening;
        this.audienceCount = audienceCount;
        this.calculateFee = calculateFee;
    }
}
