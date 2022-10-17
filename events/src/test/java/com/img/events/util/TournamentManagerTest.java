package com.img.events.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.model.Tournament;
import com.img.events.services.util.TournamentManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DMalonas
 */
@SpringBootTest
public class TournamentManagerTest {
    @Autowired
    private TournamentManager tournamentManager;


    @Test
    void testRequestToEntityForDataSource1() throws JsonProcessingException {
        String request = "{\n" +
                "    \"tournamentId\": \"174638\",\n" +
                "    \"tournamentName\": \"Women's Open Championship\",\n" +
                "    \"forecast\": \"fair\",\n" +
                "    \"courseName\": \"Sunnydale Golf Course\",\n" +
                "    \"countryCode\": \"GB\",\n" +
                "    \"startDate\": \"09/07/21\",\n" +
                "    \"endDate\": \"13/07/21\",\n" +
                "    \"roundCount\": \"4\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode requestJson = mapper.readTree(request);
        Tournament tournament = tournamentManager.requestToEntity(requestJson);
        Assertions.assertThat(tournament).isNotNull();
        Assertions.assertThat(tournament.getTournamentDataSource()).isEqualTo("Data Source 1");

    }


    @Test
    void testRequestToEntityForDataSource2() throws JsonProcessingException {
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
        ObjectMapper mapper = new ObjectMapper();
        JsonNode requestJson = mapper.readTree(request);
        Tournament tournament = tournamentManager.requestToEntity(requestJson);
        Assertions.assertThat(tournament).isNotNull();
        Assertions.assertThat(tournament.getTournamentDataSource()).isEqualTo("Data Source 2");

    }

    @Test
    void testRequestToEntityForInvalidData() throws JsonProcessingException {
        String request = "{\n" +
                "    \"tournament\":\"test\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode requestJson = mapper.readTree(request);
        Tournament tournament = tournamentManager.requestToEntity(requestJson);
        Assertions.assertThat(tournament).isNull();

    }

}
