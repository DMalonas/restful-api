package com.img.events.services.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.img.events.model.Tournament;
import com.img.events.model.Tournament1;
import com.img.events.model.Tournament2;
import com.img.events.model.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author DMalonas
 */
@Slf4j
@Component
public class TournamentManager {
    @Autowired private ObjectMapper objectMapper;

    public Tournament requestToEntity(final JsonNode tournamentData) {

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true);

        Tournament tournamentEntity = null;
        TournamentRequest tournamentRequest = buildTournament1(tournamentData);
        String tournamentDataSource = "Data Source 1";
        if (tournamentRequest == null) {
            tournamentRequest = buildTournament2(tournamentData);
            if (tournamentRequest != null) {
                tournamentDataSource = "Data Source 2";
            }
        }

        if (tournamentRequest != null) {
            tournamentEntity = buildTournamentEntity(tournamentRequest, tournamentDataSource);
        }

        return tournamentEntity;

    }

    private Tournament buildTournamentEntity(final TournamentRequest tournamentRequest, final String dataSource) {
        Tournament tournamentEntity = null;
        if ("Data Source 1".equalsIgnoreCase(dataSource)) {
            tournamentEntity = new Tournament();
            Tournament1 tournament1 = (Tournament1) tournamentRequest;
            tournamentEntity.setTournamentId(tournament1.getTournamentId());
            tournamentEntity.setTournamentName(tournament1.getTournamentName());
            tournamentEntity.setStartDate(LocalDate.parse(tournament1.getStartDate(), DateTimeFormatter.ofPattern("dd/MM/yy")));
            tournamentEntity.setEndDate(LocalDate.parse(tournament1.getEndDate(), DateTimeFormatter.ofPattern("dd/MM/yy")));
            tournamentEntity.setHostedCountryCode(tournament1.getCountryCode());
            tournamentEntity.setTournamentDataSource(dataSource);
            tournamentEntity.setNoOfRoundsPlayed(tournament1.getRoundCount());
        } else if ("Data Source 2".equalsIgnoreCase(dataSource)) {
            tournamentEntity = new Tournament();
            Tournament2 tournament2 = (Tournament2) tournamentRequest;
            tournamentEntity.setTournamentId(tournament2.getTournamentUUID());
            tournamentEntity.setGolfCourse(tournament2.getGolfCourse());
            tournamentEntity.setStartDate(convertEpochTimeToLocalDate(tournament2.getEpochStart()));
            tournamentEntity.setEndDate(convertEpochTimeToLocalDate(tournament2.getEpochStart()));
            tournamentEntity.setHostedCountry(tournament2.getHostCountry());
            tournamentEntity.setTournamentDataSource(dataSource);
            tournamentEntity.setNoOfRoundsPlayed(tournament2.getRounds());
            tournamentEntity.setTournamentName(tournament2.getCompetitionName());

        }
        return tournamentEntity;
    }


    private TournamentRequest buildTournament1(final JsonNode tournamentData) {
        TournamentRequest tournamentRequest = null;
        try {
            tournamentRequest = objectMapper.treeToValue(tournamentData, Tournament1.class);

        } catch (Exception e) {
            log.error("Error occurred while parsing json for tournament1");
        }

        return tournamentRequest;

    }

    private TournamentRequest buildTournament2(final JsonNode tournamentData) {
        TournamentRequest tournamentRequest = null;
        try {
            tournamentRequest = objectMapper.treeToValue(tournamentData, Tournament2.class);

        } catch (Exception e) {
            log.error("Error occurred while parsing json for tournament2");
        }
        return tournamentRequest;

    }

    private LocalDate convertEpochTimeToLocalDate(final Long epochTime) {
        return LocalDate.ofEpochDay(Duration.ofSeconds(epochTime).toDays());
    }
}
