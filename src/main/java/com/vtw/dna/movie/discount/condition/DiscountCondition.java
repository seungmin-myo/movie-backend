package com.vtw.dna.movie.discount.condition;

import com.vtw.dna.movie.screening.Screening;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.Arrays;

// 할인조건 인터페이스
@MappedSuperclass
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
