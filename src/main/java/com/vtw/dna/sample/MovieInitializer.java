package com.vtw.dna.sample;

import com.vtw.dna.movie.Money;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.discount.condition.PeriodCondition;
import com.vtw.dna.movie.discount.condition.SequenceCondition;
import com.vtw.dna.movie.discount.policy.AmountDiscountPolicy;
import com.vtw.dna.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Clob;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Service
public class MovieInitializer implements SampleDataInitializer {

    private final MovieRepository repository;

    public MovieInitializer(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateData() {

        Movie movie1 = new Movie("마녀(魔女) Part2",
                "27.6",
                "2022.06.08",
                Duration.ofMinutes(137),
                "액션",
                "‘자윤’이 사라진 뒤, 정체불명의 집단의 무차별 습격으로 마녀 프로젝트가 진행되고 있는 ‘아크’가 초토화된다.\n" +
                        "그곳에서 홀로 살아남은 ‘소녀’는 생애 처음 세상 밖으로 발을 내딛고\n" +
                        "우연히 만난 ‘경희’의 도움으로 농장에서 지내며 따뜻한 일상에 적응해간다.\n" +
                        "한편, ‘소녀’가 망실되자 행방을 쫓는 책임자 ‘장’과\n" +
                        "마녀 프로젝트의 창시자 ‘백총괄’의 지령을 받고 제거에 나선 본사 요원 ‘조현’,\n" +
                        "‘경희’의 농장 소유권을 노리는 조직의 보스 ‘용두’와\n" +
                        "상해에서 온 의문의 4인방까지\n" +
                        "각기 다른 목적을 지닌 세력이 하나 둘 모여들기 시작하면서 ‘소녀’ 안에 숨겨진 본성이 깨어나는데…\n" +
                        "\n" +
                        "모든 것의 시작,\n" +
                        "더욱 거대하고 강력해진 마녀가 온다.",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie2 = new Movie("범죄도시2",
                "16.4",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie3 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie4 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie5 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie6 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie7 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie8 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        Movie movie9 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );
        Movie movie10 = new Movie("마녀",
                "27",
                "2022",
                Duration.ofMinutes(137),
                "액션",
                "",
                "/assets/movie/poster/마녀2.jpg",
                "15",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)))
        );

        create(movie1);
        create(movie2);
        create(movie3);
        create(movie4);
        create(movie5);
        create(movie6);
        create(movie7);
        create(movie8);
        create(movie9);
        create(movie10);
    }

    private void create(Movie movie) {
        repository.save(movie);
    }
}
