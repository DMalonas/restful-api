package com.img.events.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.model.Tournament;
import com.img.events.model.TournamentRepository;
import com.img.events.services.TournamentService;
import com.img.events.services.util.TournamentManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TournamentServiceImplTest {

    @Mock
    private TournamentManager tournamentManager;

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    private TournamentService tournamentService;


    @Test
    void saveTournamentData() throws JsonProcessingException {
        Tournament tournament = new Tournament();
        tournament.setTournamentId("87fc6650-e114-4179-9aef-6a9a13030f80");
        tournament.setGolfCourse("Happy Days Golf Club");
        tournament.setTournamentName("South West Invitational");
        tournament.setHostedCountry("United States Of America");
        tournament.setStartDate(LocalDate.now());
        tournament.setEndDate(LocalDate.now().plusDays(2));
        tournament.setNoOfRoundsPlayed(2);
        tournament.setTournamentDataSource("Data Source 1");
        Mockito.when(tournamentManager.requestToEntity(any(JsonNode.class))).thenReturn(tournament);
        Mockito.when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
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

        Tournament savedTournament = tournamentService.processData(requestJson);
        Assertions.assertThat(savedTournament).isNotNull();
        Assertions.assertThat(savedTournament.getTournamentDataSource()).isEqualTo("Data Source 1");

    }

    @Test
    void saveTournamentDataForInvalid() throws JsonProcessingException {

        Mockito.when(tournamentManager.requestToEntity(any(JsonNode.class))).thenReturn(null);
        String request = "{\n" +
                "    \"tournament\":\"test\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode requestJson = objectMapper.readTree(request);


        Tournament savedTournament = tournamentService.processData(requestJson);
        Assertions.assertThat(savedTournament).isNull();

    }


}
