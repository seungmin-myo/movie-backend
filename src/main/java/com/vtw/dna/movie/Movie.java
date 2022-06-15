package com.vtw.dna.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vtw.dna.movie.discount.policy.DefaultDiscountPolicy;
import com.vtw.dna.movie.discount.policy.DiscountPolicy;
import com.vtw.dna.movie.screening.Screening;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Getter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 영화 ID
    private Long id;

    // 영화 제목
    private String title;

    private String advanceTicketSale;

    private String openingDate;

    // 상영 시간
    private Duration runningTime;

    private String genre;

    @Column(length = 1000)
    private String description;

    private String image;

    private String rated;

    // 영화 관람 금액
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fee_id")
    private Money fee;

    // 영화 할인 정책 정보
    @JsonIgnore
    @OneToOne(targetEntity = DefaultDiscountPolicy.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private DiscountPolicy discountPolicy;

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public Movie(String title, String advanceTicketSale, String openingDate, Duration runningTime, String genre, String description, String image, String rated, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.advanceTicketSale = advanceTicketSale;
        this.openingDate = openingDate;
        this.runningTime = runningTime;
        this.genre = genre;
        this.description = description;
        this.image = image;
        this.rated = rated;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    // 상영 정보에 따라 할인 정책을 대입하여 영화 관람 가격을 계산 후 반환
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Movie update(Movie newOne) {
        this.title = newOne.title;
        this.runningTime = newOne.runningTime;
//        this.cost = newOne.cost;
        this.fee = newOne.fee;
        this.discountPolicy = newOne.discountPolicy;
        return this;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", advanceTicketSale='" + advanceTicketSale + '\'' +
                ", openingDate='" + openingDate + '\'' +
                ", runningTime=" + runningTime +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", rated='" + rated + '\'' +
                ", fee=" + fee +
                ", discountPolicy=" + discountPolicy +
                '}';
    }
}
