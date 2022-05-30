package com.vtw.dna.movie;

import com.vtw.dna.movie.screening.Screening;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gtitle;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;



    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
