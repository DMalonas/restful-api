package com.events.dynamic_processing.controller;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.requests.TournamentRequestWrapper;
import com.events.dynamic_processing.service.TournamentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMalonas
 */
@RestController
@RequestMapping("/api/v2/tournaments")
public class TournamentDataController {

    @Autowired TournamentService tournamentService;
    @Autowired ObjectMapper mapper;


    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody JsonNode json) throws JsonProcessingException {
        TournamentRequestWrapper wrapper = mapper.treeToValue(json, TournamentRequestWrapper.class);
        Tournament tournament = wrapper.getTournamentRequest().filter(tournamentService);
        return ResponseEntity.ok(tournament);
    }
}
