package com.vtw.dna.movie.reservation;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // 고객명
    private String customerName;

    // 상영 정보
    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    // 금액
    @Transient
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
