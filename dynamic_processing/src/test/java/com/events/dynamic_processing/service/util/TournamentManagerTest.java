package com.events.dynamic_processing.service.util;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequest2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DMalonas
 */
class TournamentManagerTest {
    @Test
    void testTransformToEntityForTournament1(){
        TournamentRequest1 tournamentRequest1= new TournamentRequest1();
        tournamentRequest1.setTournamentId("123");
        tournamentRequest1.setTournamentName("test tournament");
        tournamentRequest1.setStartDate("09/07/21");
        tournamentRequest1.setEndDate("13/07/21");
        TournamentTransformer tournamentTransformer= new TournamentTransformer();
        Tournament tournament = tournamentTransformer.transformToEntity(tournamentRequest1);
        Assertions.assertThat(tournament).isNotNull();
        Assertions.assertThat(tournament.getTournamentId()).isEqualTo("123");
        Assertions.assertThat(tournament.getTournamentName()).isEqualTo("test tournament");
    }

    @Test
    void testTransformToEntityForTournament2(){
        TournamentRequest2 tournamentRequest2= new TournamentRequest2();
        tournamentRequest2.setTournamentId("456");
        tournamentRequest2.setGolfCourse("test golf");
        tournamentRequest2.setEpochStart(1638349200L);
        tournamentRequest2.setEpochFinish(1638468000L);
        TournamentTransformer tournamentTransformer= new TournamentTransformer();
        Tournament tournament = tournamentTransformer.transformToEntity(tournamentRequest2);
        Assertions.assertThat(tournament).isNotNull();
        Assertions.assertThat(tournament.getTournamentId()).isEqualTo("456");
        Assertions.assertThat(tournament.getGolfCourse()).isEqualTo("test golf");
    }
}
