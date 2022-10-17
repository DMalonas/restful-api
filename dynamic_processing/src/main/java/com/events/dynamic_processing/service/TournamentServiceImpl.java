package com.events.dynamic_processing.service;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.persistence.repositories.TournamentRepository;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequest2;
import com.events.dynamic_processing.service.util.TournamentTransformer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DMalonas
 */
@Service
@Slf4j
public class TournamentServiceImpl implements TournamentService{
    private static Logger logger = LoggerFactory.getLogger(TournamentServiceImpl.class);

    @Autowired private TournamentTransformer tournamentTransformer;
    @Autowired private TournamentRepository tournamentRepository;

    @Override
    public Tournament addTournament(TournamentRequest1 tournamentRequest1) {
        logger.info("Saving tournamentRequest1");
        Tournament tournament = tournamentTransformer.transformToEntity(tournamentRequest1);
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament addTournament(TournamentRequest2 tournamentRequest2) {
        logger.info("Saving tournamentRequest2");
        Tournament tournament = tournamentTransformer.transformToEntity(tournamentRequest2);
        return tournamentRepository.save(tournament);
    }
}
