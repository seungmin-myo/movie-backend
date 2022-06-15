package com.vtw.dna.movie.discount.policy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtw.dna.movie.discount.condition.DefaultDiscountCondition;
import com.vtw.dna.movie.discount.condition.DiscountCondition;
import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.screening.Screening;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 할인정책 추상 클래스
// 상영 정보가 할인 조건에 맞는지 확인 후 getDiscount를 호출하여 할인 금액을 계산하여 반환
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discount_policy_type")
@NoArgsConstructor
public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 할인 정책 목록
    @OneToMany(targetEntity = DefaultDiscountCondition.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... discountConditions) {
        this.conditions = Arrays.asList(discountConditions);
    }

    // 영화 할인 정책에 맞는지 판단 후 할인 금액을 계산 후 반환
    public Money calculateDiscountAmount(Screening screening) {
        // 모든 할인조건의 해당여부를 판단
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                // 해당한다면 추상 메소드를 호출하여 할인 요금을 계산
                return getDiscountAmount(screening);
            }
        }
        // 해당하지 않는다면 할인금액은 0원
        return Money.wons(0);
    }

    // 상영 정보를 기준으로 할인 금액을 계산 후 반환
    // DefaultDiscountPolicy를 상속받은 자식클래스에서 오버라이딩한 메소드가 실행
    abstract protected Money getDiscountAmount(Screening screening);
}
