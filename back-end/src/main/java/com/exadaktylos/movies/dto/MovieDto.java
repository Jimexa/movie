package com.exadaktylos.movies.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;

    private String title;

    private LocalDate year;
}
