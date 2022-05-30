package com.vtw.dna.movie;

import com.vtw.dna.movie.screening.Screening;
import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 기간조건
@AllArgsConstructor
public class PeriodCondition implements DiscountCondition{
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }

}
