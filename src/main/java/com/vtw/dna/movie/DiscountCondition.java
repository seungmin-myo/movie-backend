package com.vtw.dna.movie;

import com.vtw.dna.movie.screening.Screening;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

// 할인조건 인터페이스
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
