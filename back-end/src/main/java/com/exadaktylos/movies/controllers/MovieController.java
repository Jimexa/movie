package com.exadaktylos.movies.controllers;

import com.exadaktylos.movies.dto.DetailsDto;
import com.exadaktylos.movies.dto.MovieDto;
import com.exadaktylos.movies.dto.MovieStoreDto;
import com.exadaktylos.movies.exceptions.MovieErrorResponse;
import com.exadaktylos.movies.exceptions.MovieNotFoundException;
import com.exadaktylos.movies.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<MovieDto> all() {

        log.info("Get all movies");

        return movieService.getMovies();
    }

    @GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DetailsDto movieDetails(@PathVariable("movieId") Long movieId) {

        log.info("Get movie_details with id {}", movieId);

        return movieService.getMovieDetails(movieId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveMovie(@RequestBody MovieStoreDto movieStoreDto) {

        log.info("Store movie with title {}", movieStoreDto.getTitle());

        movieService.saveMovie(movieStoreDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<MovieErrorResponse> exceptionHandler(Exception ex) {

        MovieErrorResponse movieErrorResponse = MovieErrorResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<MovieErrorResponse>(movieErrorResponse, HttpStatus.OK);
    }
}
