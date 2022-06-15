package com.vtw.dna.movie.discount.policy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;

import javax.persistence.MappedSuperclass;

//@JsonSubTypes({
//        @JsonSubTypes.Type(value = DefaultDiscountPolicy.class, name = "policy"),
////        @JsonSubTypes.Type(value = C.class, name = "non"),
//})
@MappedSuperclass
public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
