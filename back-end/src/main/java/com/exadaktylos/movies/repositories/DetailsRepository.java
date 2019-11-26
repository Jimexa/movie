package com.exadaktylos.movies.repositories;

import com.exadaktylos.movies.domain.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

    Optional<Details> findByMovieId(Long movieId);
}
