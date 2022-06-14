package com.vtw.dna.movie.discount.condition;

import com.vtw.dna.movie.screening.Screening;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// 순서조건
@Entity
@DiscriminatorValue("sequence")
@NoArgsConstructor
public class SequenceCondition extends DefaultDiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    protected boolean isSatisfied(Screening screening) {
        return screening.isSequence(sequence);
    }


}
