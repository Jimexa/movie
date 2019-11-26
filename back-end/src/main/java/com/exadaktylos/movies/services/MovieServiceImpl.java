package com.exadaktylos.movies.services;

import com.exadaktylos.movies.domain.Details;
import com.exadaktylos.movies.domain.Movie;
import com.exadaktylos.movies.dto.DetailsDto;
import com.exadaktylos.movies.dto.MovieDto;
import com.exadaktylos.movies.dto.MovieStoreDto;
import com.exadaktylos.movies.exceptions.MovieNotFoundException;
import com.exadaktylos.movies.repositories.DetailsRepository;
import com.exadaktylos.movies.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DetailsRepository detailsRepository;

    @Override
    public List<MovieDto> getMovies() {

        log.info("Fetch all movies process start");

        List<Movie> movies = movieRepository.findAll();

        List<MovieDto> movieDtoList = new ArrayList<>(movies.size());

        movies.stream().map(movie -> movieDtoList.add(conversionService.convert(movie, MovieDto.class)))
                .collect(Collectors.toList());

        log.info("Fetch all movies process end");

        return movieDtoList;
    }

    @Override
    public DetailsDto getMovieDetails(Long movieId) {

        log.info("Fetch movie_details with id {} process start", movieId);

        Optional<Details> details = detailsRepository.findByMovieId(movieId);

        if(details.isPresent())
            return conversionService.convert(details.get(), DetailsDto.class);

        details.orElseThrow(() -> new MovieNotFoundException("Not found movie with id " + movieId));

        log.info("Fetch movie_details process end");

        return null;
    }

    @Override
    @Transactional
    public void saveMovie(MovieStoreDto movieStoreDto) {

        log.info("Save movie process start");

        Details details = createDetails(movieStoreDto, createMovie(movieStoreDto));

        detailsRepository.save(details);

        log.info("Save movie process end");
    }

    Movie createMovie(MovieStoreDto movieStoreDto){

        return Movie.builder()
                .title(movieStoreDto.getTitle())
                .year(movieStoreDto.getYear())
                .insertedByUser("EXADAKTYLOS")
                .timeInserted(Instant.now())
                .build();
    }

    Details createDetails(MovieStoreDto movieStoreDto, Movie movie){
        return Details.builder()
                .director(movieStoreDto.getDirector())
                .description(movieStoreDto.getDescription())
                .insertedByUser("EXADAKTYLOS")
                .timeInserted(Instant.now())
                .movie(movie)
                .build();
    }
}
