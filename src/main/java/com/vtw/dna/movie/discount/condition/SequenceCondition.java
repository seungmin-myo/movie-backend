package com.vtw.dna.movie.discount.condition;

import com.vtw.dna.movie.screening.Screening;

// 순서조건
public class SequenceCondition implements DiscountCondition{
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
