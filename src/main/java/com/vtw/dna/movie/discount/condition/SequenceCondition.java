package com.vtw.dna.movie.discount.condition;

import com.vtw.dna.movie.screening.Screening;
import lombok.AllArgsConstructor;

// 순서조건
@AllArgsConstructor
public class SequenceCondition implements DiscountCondition{
    private int sequence;

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
