package com.vtw.dna.movie;

import com.vtw.dna.movie.discount.policy.DefaultDiscountPolicy;
import com.vtw.dna.movie.discount.policy.DiscountPolicy;
import com.vtw.dna.movie.screening.Screening;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 영화 ID
    private Long id;

    // 영화 제목
    private String title;

    // 상영 시간
    private Duration runningTime;

    // 영화 관람 금액
    @Getter
    @Transient
    private Money fee;

    // 영화 할인 정책 정보
    @Transient
    private DiscountPolicy discountPolicy;


    // 상영 정보에 따라 할인 정책을 대입하여 영화 관람 가격을 계산 후 반환
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
