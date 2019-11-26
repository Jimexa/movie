package com.exadaktylos.movies.convert;

import com.exadaktylos.movies.domain.Details;
import com.exadaktylos.movies.dto.DetailsDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DetailsToDetailsDtoConverter implements Converter<Details, DetailsDto> {

    @Override
    public DetailsDto convert(Details details) {

        return DetailsDto.builder()
                .title(details.getMovie().getTitle())
                .description(details.getDescription())
                .director(details.getDirector())
                .build();
    }
}
