package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// 할인 정책이 없을 때
@Entity
public class NoneDiscountPolicy implements DiscountPolicy{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // 할인 정책이 없으므로 할인 금액을 0원으로 반환
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.wons(0);
    }
}
