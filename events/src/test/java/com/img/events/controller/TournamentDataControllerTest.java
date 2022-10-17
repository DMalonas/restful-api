package com.img.events.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.controllers.TournamentDataController;
import com.img.events.model.Tournament;
import com.img.events.services.TournamentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author DMalonas
 */
@ExtendWith(MockitoExtension.class)
public class TournamentDataControllerTest {
    @Mock
    private TournamentService tournamentService;

    @InjectMocks
    private TournamentDataController tournamentController;


    @Test
    void testSaveTournament() throws JsonProcessingException {
        Tournament tournament = new Tournament();
        tournament.setTournamentId("87fc6650-e114-4179-9aef-6a9a13030f80");
        tournament.setGolfCourse("Happy Days Golf Club");
        tournament.setTournamentName("South West Invitational");
        tournament.setHostedCountry("United States Of America");
        tournament.setStartDate(LocalDate.now());
        tournament.setEndDate(LocalDate.now().plusDays(2));
        tournament.setNoOfRoundsPlayed(2);
        tournament.setTournamentDataSource("Data Source 1");
        Mockito.when(tournamentService.processData(any(JsonNode.class))).thenReturn(tournament);
        String request = "{\n" +
                "    \"tournamentUUID\":\"87fc6650-e114-4179-9aef-6a9a13030f80\",\n" +
                "    \"golfCourse\":\"Happy Days Golf Club\",\n" +
                "    \"competitionName\":\"South West Invitational\",\n" +
                "    \"hostCountry\":\"United States Of America\",\n" +
                "    \"epochStart\":\"1638349200\",\n" +
                "    \"epochFinish\":\"1638468000\",\n" +
                "    \"rounds\":\"2\",\n" +
                "    \"playerCount\":\"35\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode requestJson = objectMapper.readTree(request);


        ResponseEntity<?> response = tournamentController.saveTournament(requestJson);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isEqualTo(tournament);

    }

    @Test
    void testSaveTournamentForBadRequest() throws JsonProcessingException {

        Mockito.when(tournamentService.processData(any(JsonNode.class))).thenReturn(null);
        String request = "{\n" +
                "    \"tournament\":\"test\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode requestJson = objectMapper.readTree(request);


        ResponseEntity<?> response = tournamentController.saveTournament(requestJson);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(response.getBody()).isEqualTo("Invalid tournament data passed.");

    }
}
