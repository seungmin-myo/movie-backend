package com.vtw.dna.movie;

import com.vtw.dna.employee.Employee;
import com.vtw.dna.movie.discount.policy.AmountDiscountPolicy;
import com.vtw.dna.movie.discount.policy.DefaultDiscountPolicy;
import com.vtw.dna.movie.discount.policy.DiscountPolicy;
import com.vtw.dna.movie.screening.Screening;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;

@Entity
@Getter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 영화 ID
    private Long id;

    // 영화 제목
    private String title;

    // 상영 시간
    private Duration runningTime;

    private BigDecimal cost;

    // 영화 관람 금액
    @Transient
    private Money fee;

    // 영화 할인 정책 정보
    @Transient
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, BigDecimal cost, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.cost = cost;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    // 상영 정보에 따라 할인 정책을 대입하여 영화 관람 가격을 계산 후 반환
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Movie update(Movie newOne) {
        this.title = newOne.title;
        this.runningTime = newOne.runningTime;
//        this.fee = newOne.fee;
//        this.discountPolicy = newOne.discountPolicy;
        return this;
    }

}
