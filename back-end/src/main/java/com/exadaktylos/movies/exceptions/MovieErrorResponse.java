package com.exadaktylos.movies.exceptions;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieErrorResponse {

    private int errorCode;

    private String message;
}
