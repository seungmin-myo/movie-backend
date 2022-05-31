package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.discount.condition.DiscountCondition;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 할인정책 추상 클래스
// 상영 정보가 할인 조건에 맞는지 확인 후 getDiscount를 호출하여 할인 금액을 계산하여 반환
public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    // 할인 정책 목록
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... discountConditions) {
        this.conditions = Arrays.asList(discountConditions);
    }

    // 영화 할인 정책에 맞는지 판단 후 할인 금액을 계산 후 반환
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    // 상영 정보를 기준으로 할인 금액을 계산 후 반환
    abstract protected Money getDiscountAmount(Screening screening);
}
