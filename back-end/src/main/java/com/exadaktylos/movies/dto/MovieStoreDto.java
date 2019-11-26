package com.exadaktylos.movies.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieStoreDto {

    private String title;

    private String director;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate year;

    private String description;
}
