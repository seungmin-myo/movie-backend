package com.vtw.dna.movie.screening;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.reservation.Reservation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 영화
//    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    
    // 회차
    private int sequence;
    
    // 시작 시간
    private LocalDateTime whenScreened;

    // 시작 시간 반환
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 인자로 들어온 회차와 같은 회차인지 판단
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    // 가격 반환
    public Money getMovieFee() {
        return movie.getFee();
    }

    // 1인당 가격을 구한 후 인원 수 만큼 곱한 후 반환
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    // 예약 정보 반환
    public Reservation reserve(String name, int audienceCount) {
        return new Reservation(name, this, calculateFee(audienceCount), audienceCount);
    }



}
