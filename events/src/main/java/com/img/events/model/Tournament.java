package com.img.events.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author DMalonas
 */
@Data
@Entity
public class Tournament {
    @Id
    @Column
    private String tournamentId;

    @Column
    private String tournamentName;

    @Column
    private String golfCourse;

    @Column
    private String hostedCountry;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private Integer noOfRoundsPlayed;

    @Column
    private String hostedCountryCode;

    @Column
    private String tournamentDataSource;
}
