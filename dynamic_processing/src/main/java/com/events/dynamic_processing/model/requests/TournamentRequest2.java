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
public class TournamentRequest2 implements TournamentRequest {
    @JsonProperty("tournamentUUID") private String tournamentId;
    @JsonProperty private String golfCourse;
    @JsonProperty private String competitionName;
    @JsonProperty private String hostCountry;
    @JsonProperty private Long epochStart;
    @JsonProperty private Long epochFinish;
    @JsonProperty private Integer rounds;
    @JsonProperty private Integer playerCount;

    @Override
    public Tournament filter(TournamentService tournamentService) {
        return tournamentService.addTournament(this);
    }

}
