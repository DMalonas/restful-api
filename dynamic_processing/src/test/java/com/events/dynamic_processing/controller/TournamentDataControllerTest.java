package com.events.dynamic_processing.controller;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequestWrapper;
import com.events.dynamic_processing.service.TournamentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

/**
 * @author DMalonas
 */
@ExtendWith(MockitoExtension.class)
class TournamentDataControllerTest {
    @Mock private TournamentService tournamentService;

    @Mock private ObjectMapper mapper;
    @InjectMocks private TournamentDataController tournamentController;

    @Test
    void testSaveTournament() throws Exception {
        Tournament tournament = new Tournament();
        tournament.setTournamentDataSource("Data Source 1");
        TournamentRequestWrapper wrapper = Mockito.mock(TournamentRequestWrapper.class);
        TournamentRequest1 tournamentRequest1 = Mockito.mock(TournamentRequest1.class);
        Mockito.when(mapper.treeToValue(any(JsonNode.class), eq(TournamentRequestWrapper.class)))
                .thenReturn(wrapper);
        Mockito.when(wrapper.getTournamentRequest()).thenReturn(tournamentRequest1);
        Mockito.when(tournamentRequest1.filter(any(TournamentService.class)))
                .thenReturn(tournament);
        String request = """
                {
                    "source": "Data Source 1",
                    "tournamentRequest": {
                        "tournamentId": "174638",
                        "tournamentName": "Women's Open Championship",
                        "forecast": "fair",
                        "courseName": "Sunnydale Golf Course",
                        "countryCode": "GB",
                        "startDate": "09/07/21",
                        "endDate": "13/07/21",
                        "roundCount": "4"
                    }
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(request);
        ResponseEntity<Tournament> tournamentResponseEntity = tournamentController.addTournament(jsonNode);
        Assertions.assertThat(tournamentResponseEntity).isNotNull();
        Assertions.assertThat(tournamentResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(tournamentResponseEntity.getBody()).isEqualTo(tournament);
    }
}
