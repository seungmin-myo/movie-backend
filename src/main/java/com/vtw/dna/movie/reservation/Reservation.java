package com.vtw.dna.movie.reservation;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 고객명
    private String customerName;

    // 상영 정보
    @ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    private BigDecimal discountCost;

    // 금액
//    @Transient
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fee_id")
    private Money fee;

    // 인원 수
    private int audienceCount;

    public Reservation(String customerName, Screening screening, Money fee, int audienceCount) {
        this.customerName = customerName;
        this.screening = screening;
        this.discountCost = fee.getAmount();
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Reservation update(Reservation newOne) {
        this.customerName = newOne.customerName;
        this.screening = newOne.screening;
//        this.fee = newOne.fee;
        this.audienceCount = newOne.audienceCount;
        return this;
    }
}
