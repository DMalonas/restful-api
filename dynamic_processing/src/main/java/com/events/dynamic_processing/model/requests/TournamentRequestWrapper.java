package com.events.dynamic_processing.model.requests;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * @author DMalonas
 */
@Data
public class TournamentRequestWrapper {
    private String source;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "source", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = TournamentRequest1.class, name = "Data Source 1"),
            @JsonSubTypes.Type(value = TournamentRequest2.class, name = "Data Source 2")
    })
    private TournamentRequest tournamentRequest;

}
