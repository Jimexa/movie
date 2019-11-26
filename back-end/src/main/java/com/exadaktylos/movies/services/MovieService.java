package com.exadaktylos.movies.services;

import com.exadaktylos.movies.dto.DetailsDto;
import com.exadaktylos.movies.dto.MovieDto;
import com.exadaktylos.movies.dto.MovieStoreDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<MovieDto> getMovies();

    DetailsDto getMovieDetails(Long movieId);

    void saveMovie(MovieStoreDto movieStoreDto);
}
