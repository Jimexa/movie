package com.exadaktylos.movies.convert;

import com.exadaktylos.movies.domain.Movie;
import com.exadaktylos.movies.dto.MovieDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieToMovieDtoConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie movie) {

        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .year(movie.getYear())
                .build();
    }
}
