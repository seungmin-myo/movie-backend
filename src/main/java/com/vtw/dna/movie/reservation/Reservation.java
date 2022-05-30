package com.vtw.dna.movie.reservation;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    private String customerName;
    @ManyToOne
    @JoinColumn(name = "fee_id")
    private Money fee;
    private int audienceCount;


    public Reservation(String customerName, Screening screening, Money fee, int audienceCount) {
        this.customerName = customerName;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
