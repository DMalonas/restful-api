package com.img.events.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.img.events.model.Tournament;

/**
 * @author DMalonas
 */
public interface TournamentService {
    Tournament processData(JsonNode tournamentRequest);

}
