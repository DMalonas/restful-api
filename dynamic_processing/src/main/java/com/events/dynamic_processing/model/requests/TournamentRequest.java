package com.events.dynamic_processing.model.requests;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.service.TournamentService;

/**
 * @author DMalonas
 */

public abstract interface TournamentRequest {
    public abstract Tournament filter(TournamentService tournamentService);
}
