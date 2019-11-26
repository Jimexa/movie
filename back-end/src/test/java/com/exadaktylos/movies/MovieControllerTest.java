package com.exadaktylos.movies;

import com.exadaktylos.movies.config.H2TestProfileJPAConfig;
import com.exadaktylos.movies.dto.MovieStoreDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MoviesApplication.class, H2TestProfileJPAConfig.class})
public class MovieControllerTest<SpringApplicationConfiguration> {

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation  =
            new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    private static final Long MOVIE_TO_FIND = 1L;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc =
                MockMvcBuilders.webAppContextSetup(this.context)
                        .apply(documentationConfiguration(this.jUnitRestDocumentation ))
                        .alwaysDo(document("{class-name}/{method-name}",
                                preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                        .build();
    }

    @Test
    public void findAllMovies() throws Exception {
        this.mockMvc.perform(get("/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void findMovieDetailsByMovieId() throws Exception {
        this.mockMvc.perform(get("/movies/{movieId}",MOVIE_TO_FIND))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void saveMovie() throws Exception {

        MovieStoreDto movieStoreDto = MovieStoreDto.builder()
                .title("Mock Title")
                .director("Mock Director")
                .year(LocalDate.now())
                .description("Mock Description")
                .build();

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/movies")
                        .content(asJsonString(movieStoreDto)).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
