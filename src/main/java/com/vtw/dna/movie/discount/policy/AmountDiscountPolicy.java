package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.discount.condition.DiscountCondition;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

// 금액 할인 정책
public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }

}
