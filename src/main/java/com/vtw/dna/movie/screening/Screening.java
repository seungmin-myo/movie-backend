package com.vtw.dna.movie.screening;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.reservation.Reservation;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 영화
    @ManyToOne
    private Movie movie;

    // 회차
    private int sequence;

    // 시작 시간
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

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
    public Reservation reserve(String customerName, int audienceCount) {
        return new Reservation(customerName, this, calculateFee(audienceCount), audienceCount);
    }

    public Screening update(Screening newOne) {
        this.movie = newOne.movie;
        this.sequence = newOne.sequence;
        this.whenScreened = newOne.whenScreened;
        return this;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}