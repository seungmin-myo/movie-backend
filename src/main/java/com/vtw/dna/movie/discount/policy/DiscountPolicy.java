package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
