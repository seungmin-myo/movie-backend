package com.vtw.dna.movie.discount.condition;

import com.vtw.dna.movie.screening.Screening;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="condition_type")
public abstract class DefaultDiscountCondition implements DiscountCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isSatisfiedBy(Screening screening) {
        return isSatisfied(screening);
    }

    abstract protected boolean isSatisfied(Screening screening);
}
