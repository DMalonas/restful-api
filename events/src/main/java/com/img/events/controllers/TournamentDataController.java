package com.img.events.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.img.events.model.Tournament;
import com.img.events.services.TournamentService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/api/tournaments")
public class TournamentDataController {
    @Autowired private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity<?> saveTournament(@RequestBody JsonNode tournamentRequest) {
        Tournament tournament = tournamentService.processData(tournamentRequest);
        if (tournament != null) {
            return ResponseEntity.ok(tournament);
        } else {
            return ResponseEntity.badRequest().body("Invalid tournament data passed.");
        }
    }
}
