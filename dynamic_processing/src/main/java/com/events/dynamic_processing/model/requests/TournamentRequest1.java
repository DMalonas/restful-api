package com.events.dynamic_processing.model.requests;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.service.TournamentService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author DMalonas
 */
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequest1 implements TournamentRequest {
    @JsonProperty("tournamentId") private String tournamentId;
    @JsonProperty private String tournamentName;
    @JsonProperty private String forecast;
    @JsonProperty private String courseName;
    @JsonProperty private String countryCode;
    @JsonProperty private String startDate;
    @JsonProperty private String endDate;
    @JsonProperty private Integer roundCount;

    @Override
    public Tournament filter(TournamentService tournamentService) {
        return tournamentService.addTournament(this);
    }
}
