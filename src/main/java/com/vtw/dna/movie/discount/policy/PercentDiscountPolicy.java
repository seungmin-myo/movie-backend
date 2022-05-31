package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.discount.condition.DiscountCondition;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

// 비율 할인 정책
public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    // 영화 가격에서 특정 비율만큼을 할인금액으로 계산 후 반환
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
