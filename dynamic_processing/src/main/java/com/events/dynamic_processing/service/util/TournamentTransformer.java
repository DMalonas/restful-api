package com.events.dynamic_processing.service.util;

import com.events.dynamic_processing.model.persistence.Tournament;
import com.events.dynamic_processing.model.requests.TournamentRequest1;
import com.events.dynamic_processing.model.requests.TournamentRequest2;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author DMalonas
 */
@Component
public class TournamentTransformer {
    public Tournament transformToEntity(final TournamentRequest1 tournamentRequest) {
        Tournament tournamentEntity = new Tournament();
        TournamentRequest1 tournamentRequest1 = tournamentRequest;
        tournamentEntity.setTournamentId(tournamentRequest1.getTournamentId());
        tournamentEntity.setTournamentName(tournamentRequest1.getTournamentName());
        tournamentEntity.setStartDate(LocalDate.parse(tournamentRequest1.getStartDate(), DateTimeFormatter.ofPattern("dd/MM/yy")));
        tournamentEntity.setEndDate(LocalDate.parse(tournamentRequest1.getEndDate(), DateTimeFormatter.ofPattern("dd/MM/yy")));
        tournamentEntity.setHostedCountryCode(tournamentRequest1.getCountryCode());
        tournamentEntity.setTournamentDataSource("Data Source 1");
        tournamentEntity.setNoOfRoundsPlayed(tournamentRequest1.getRoundCount());
        return tournamentEntity;
    }


    public Tournament transformToEntity(final TournamentRequest2 tournamentRequest2) {
        Tournament tournamentEntity = new Tournament();

        tournamentEntity.setTournamentId(tournamentRequest2.getTournamentId());
        tournamentEntity.setGolfCourse(tournamentRequest2.getGolfCourse());
        tournamentEntity.setStartDate(convertEpochTimeToLocalDate(tournamentRequest2.getEpochStart()));
        tournamentEntity.setEndDate(convertEpochTimeToLocalDate(tournamentRequest2.getEpochStart()));
        tournamentEntity.setHostedCountry(tournamentRequest2.getHostCountry());
        tournamentEntity.setTournamentDataSource("Data Source 2");
        tournamentEntity.setNoOfRoundsPlayed(tournamentRequest2.getRounds());
        tournamentEntity.setTournamentName(tournamentRequest2.getCompetitionName());
        return tournamentEntity;
    }

    private LocalDate convertEpochTimeToLocalDate(final Long epochTime) {
        return LocalDate.ofEpochDay(Duration.ofSeconds(epochTime).toDays());
    }

}
