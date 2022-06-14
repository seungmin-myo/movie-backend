package com.vtw.dna.movie.discount.policy;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
