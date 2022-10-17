package com.img.events.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.img.events.model.Tournament;
import com.img.events.model.TournamentRepository;
import com.img.events.services.util.TournamentManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DMalonas
 */
@Slf4j
@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired  private TournamentManager tournamentManager;
    @Autowired private TournamentRepository tournamentRepository;

    @Override public Tournament processData(JsonNode tournamentRequest) {
        Tournament tournament = tournamentManager.requestToEntity(tournamentRequest);
        if(tournament!= null){
            Tournament savedTournamentData = tournamentRepository.save(tournament);
            return  savedTournamentData;
        }else {
            log.error("Failed to save the tournament Data.");
        }
        return  tournament;
    }
}
