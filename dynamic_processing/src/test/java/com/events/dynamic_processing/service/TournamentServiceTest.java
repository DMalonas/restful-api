package com.events.dynamic_processing.service;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.persistence.repositories.TournamentRepository;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequest2;
import com.events.dynamic_processing.service.util.TournamentTransformer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author DMalonas
 */
@ExtendWith(MockitoExtension.class)
class TournamentServiceTest {
    @Mock private TournamentTransformer tournamentTransformer;
    @Mock private TournamentRepository tournamentRepository;
    @InjectMocks private TournamentServiceImpl tournamentService;

    @Test
    void testSaveTournamentRequest1(){
        Tournament tournament = new Tournament();
        tournament.setTournamentDataSource("Data Source 1");
        Mockito.when(tournamentTransformer.transformToEntity(any(TournamentRequest1.class)))
                .thenReturn(tournament);
        TournamentRequest1 tournamentRequest1= new TournamentRequest1();
        tournamentRequest1.setTournamentId("123");
        Mockito.when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        Tournament tournament1 = tournamentService.addTournament(tournamentRequest1);
        Assertions.assertThat(tournament1).isNotNull();
        Assertions.assertThat(tournament1.getTournamentDataSource()).isEqualTo("Data Source 1");
    }


    @Test
    void testSaveTournamentRequest2(){
        Tournament tournament = new Tournament();
        tournament.setTournamentDataSource("Data Source 2");
        Mockito.when(tournamentTransformer.transformToEntity(any(TournamentRequest2.class)))
                .thenReturn(tournament);
        TournamentRequest2 tournamentRequest2= new TournamentRequest2();
        tournamentRequest2.setTournamentId("123");
        Mockito.when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        Tournament tournament2 = tournamentService.addTournament(tournamentRequest2);
        Assertions.assertThat(tournament2).isNotNull();
        Assertions.assertThat(tournament2.getTournamentDataSource()).isEqualTo("Data Source 2");

    }
}
