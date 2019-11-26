package com.exadaktylos.movies.domain;

import java.io.Serializable;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;

import java.time.Instant;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Details implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "DIRECTOR")
    private String director;

    @NotNull
    @Column(name = "DESC")
    private String description;

    @Column(name = "USERINSERT")
    private String insertedByUser;

    @Column(name = "TIMEINSERT")
    private Instant timeInserted;

    @NotNull
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}
