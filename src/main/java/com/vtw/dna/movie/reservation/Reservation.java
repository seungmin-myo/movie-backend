package com.vtw.dna.movie.reservation;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.Data;

import javax.persistence.*;

//@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상영 정보
//    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    // 고객명
    private String customerName;

    // 금액
    private Money fee;

    // 인원 수
    private int audienceCount;


    public Reservation(String customerName, Screening screening, Money fee, int audienceCount) {
        this.customerName = customerName;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
