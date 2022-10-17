package com.img.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author DMalonas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament2 implements TournamentRequest {
    @NonNull @JsonProperty private String tournamentUUID;
    @JsonProperty private String golfCourse;
    @JsonProperty private String competitionName;
    @JsonProperty private String hostCountry;
    @JsonProperty private Long epochStart;
    @JsonProperty private Long epochFinish;
    @JsonProperty private Integer rounds;
    @JsonProperty private Integer playerCount;
}