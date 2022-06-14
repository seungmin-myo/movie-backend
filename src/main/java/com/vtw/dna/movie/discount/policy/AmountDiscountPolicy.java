package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.discount.condition.DiscountCondition;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

// 금액 할인 정책
@Entity
@DiscriminatorValue("amount")
@Getter
@NoArgsConstructor
public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    // 할인금액
//    @Transient
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_amount_id")
    private Money discountAmount;

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }

}
