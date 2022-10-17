package com.events.dynamic_processing.service;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequest2;

/**
 * @author DMalonas
 */
public interface TournamentService {
    Tournament addTournament(TournamentRequest1 tournamentRequest1);
    Tournament addTournament(TournamentRequest2 tournamentRequest2);
}
