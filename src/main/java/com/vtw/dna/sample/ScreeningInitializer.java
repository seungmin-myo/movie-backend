package com.vtw.dna.sample;

import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.movie.screening.Screening;
import com.vtw.dna.movie.screening.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScreeningInitializer implements SampleDataInitializer {

    private final ScreeningRepository repository;
    private final MovieRepository movieRepository;

    public ScreeningInitializer(ScreeningRepository repository, MovieRepository movieRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void generateData() {

        Screening screening1_1 = new Screening(
                movieRepository.getById(1L),
                1,
                LocalDateTime.of(2022,06,14, 10, 00)
        );
        Screening screening1_2 = new Screening(
                movieRepository.getById(1L),
                2,
                LocalDateTime.of(2022,06,14, 14, 00)
        );
        Screening screening1_3 = new Screening(
                movieRepository.getById(1L),
                3,
                LocalDateTime.of(2022,06,14, 18, 00)
        );

        Screening screening2_1 = new Screening(
                movieRepository.getById(2L),
                1,
                LocalDateTime.of(2022,06,14, 9, 00)
        );
        Screening screening2_2 = new Screening(
                movieRepository.getById(2L),
                2,
                LocalDateTime.of(2022,06,14, 13, 00)
        );
        Screening screening2_3 = new Screening(
                movieRepository.getById(2L),
                3,
                LocalDateTime.of(2022,06,14, 17, 00)
        );

        Screening screening3_1 = new Screening(
                movieRepository.getById(3L),
                1,
                LocalDateTime.of(2022,06,14, 8, 00)
        );
        Screening screening3_2 = new Screening(
                movieRepository.getById(3L),
                2,
                LocalDateTime.of(2022,06,14, 12, 00)
        );
        Screening screening3_3 = new Screening(
                movieRepository.getById(3L),
                3,
                LocalDateTime.of(2022,06,14, 16, 00)
        );

        Screening screening4_1 = new Screening(
                movieRepository.getById(4L),
                1,
                LocalDateTime.of(2022,06,14, 11, 00)
        );
        Screening screening4_2 = new Screening(
                movieRepository.getById(4L),
                2,
                LocalDateTime.of(2022,06,14, 15, 00)
        );
        Screening screening4_3 = new Screening(
                movieRepository.getById(4L),
                3,
                LocalDateTime.of(2022,06,14, 19, 00)
        );

        Screening screening5_1 = new Screening(
                movieRepository.getById(5L),
                1,
                LocalDateTime.of(2022,06,14, 12, 00)
        );
        Screening screening5_2 = new Screening(
                movieRepository.getById(5L),
                2,
                LocalDateTime.of(2022,06,14, 16, 00)
        );
        Screening screening5_3 = new Screening(
                movieRepository.getById(5L),
                3,
                LocalDateTime.of(2022,06,14, 20, 00)
        );

        Screening screening6_1 = new Screening(
                movieRepository.getById(6L),
                1,
                LocalDateTime.of(2022,06,14, 13, 00)
        );
        Screening screening6_2 = new Screening(
                movieRepository.getById(6L),
                2,
                LocalDateTime.of(2022,06,14, 17, 00)
        );
        Screening screening6_3 = new Screening(
                movieRepository.getById(6L),
                3,
                LocalDateTime.of(2022,06,14, 21, 00)
        );

        Screening screening7_1 = new Screening(
                movieRepository.getById(7L),
                1,
                LocalDateTime.of(2022,06,14, 14, 00)
        );
        Screening screening7_2 = new Screening(
                movieRepository.getById(7L),
                2,
                LocalDateTime.of(2022,06,14, 18, 00)
        );
        Screening screening7_3 = new Screening(
                movieRepository.getById(7L),
                3,
                LocalDateTime.of(2022,06,14, 22, 00)
        );

        Screening screening8_1 = new Screening(
                movieRepository.getById(8L),
                1,
                LocalDateTime.of(2022,06,14, 15, 00)
        );
        Screening screening8_2 = new Screening(
                movieRepository.getById(8L),
                2,
                LocalDateTime.of(2022,06,14, 19, 00)
        );
        Screening screening8_3 = new Screening(
                movieRepository.getById(8L),
                3,
                LocalDateTime.of(2022,06,14, 23, 00)
        );

        Screening screening9_1 = new Screening(
                movieRepository.getById(9L),
                1,
                LocalDateTime.of(2022,06,14, 7, 00)
        );
        Screening screening9_2 = new Screening(
                movieRepository.getById(9L),
                2,
                LocalDateTime.of(2022,06,14, 11, 00)
        );
        Screening screening9_3 = new Screening(
                movieRepository.getById(9L),
                3,
                LocalDateTime.of(2022,06,14, 15, 00)
        );

        Screening screening10_1 = new Screening(
                movieRepository.getById(10L),
                1,
                LocalDateTime.of(2022,06,14, 10, 00)
        );
        Screening screening10_2 = new Screening(
                movieRepository.getById(10L),
                2,
                LocalDateTime.of(2022,06,14, 14, 00)
        );
        Screening screening10_3 = new Screening(
                movieRepository.getById(10L),
                3,
                LocalDateTime.of(2022,06,14, 18, 00)
        );

        create(screening1_1);
        create(screening1_2);
        create(screening1_3);
        create(screening2_1);
        create(screening2_2);
        create(screening2_3);
        create(screening3_1);
        create(screening3_2);
        create(screening3_3);
        create(screening4_1);
        create(screening4_2);
        create(screening4_3);
        create(screening5_1);
        create(screening5_2);
        create(screening5_3);
        create(screening6_1);
        create(screening6_2);
        create(screening6_3);
        create(screening7_1);
        create(screening7_2);
        create(screening7_3);
        create(screening8_1);
        create(screening8_2);
        create(screening8_3);
        create(screening9_1);
        create(screening9_2);
        create(screening9_3);
        create(screening10_1);
        create(screening10_2);
        create(screening10_3);
    }

    private void create(Screening screening) {
        repository.save(screening);
    }
}
