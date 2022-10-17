package com.img.events.model;

import com.fasterxml.jackson.annotation.JsonCreator;
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
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament1 implements TournamentRequest {
    @NonNull @JsonProperty private String tournamentId;
    @JsonProperty private String tournamentName;
    @JsonProperty private String forecast;
    @JsonProperty private String courseName;
    @JsonProperty private String countryCode;
    @JsonProperty private String startDate;
    @JsonProperty private String endDate;
    @JsonProperty private Integer roundCount;
}