package com.exadaktylos.movies.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private String title;

    private String description;

    private String director;
}
