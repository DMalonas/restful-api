package com.events.dynamic_processing.model.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author DMalonas
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id @Column private String tournamentId;
    @Column private String tournamentName;
    @Column private String golfCourse;
    @Column private String hostedCountry;
    @Column private LocalDate startDate;
    @Column private LocalDate endDate;
    @Column private Integer noOfRoundsPlayed;
    @Column private String hostedCountryCode;
    @Column private String tournamentDataSource;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getGolfCourse() {
        return golfCourse;
    }

    public void setGolfCourse(String golfCourse) {
        this.golfCourse = golfCourse;
    }

    public String getHostedCountry() {
        return hostedCountry;
    }

    public void setHostedCountry(String hostedCountry) {
        this.hostedCountry = hostedCountry;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getNoOfRoundsPlayed() {
        return noOfRoundsPlayed;
    }

    public void setNoOfRoundsPlayed(Integer noOfRoundsPlayed) {
        this.noOfRoundsPlayed = noOfRoundsPlayed;
    }

    public String getHostedCountryCode() {
        return hostedCountryCode;
    }

    public void setHostedCountryCode(String hostedCountryCode) {
        this.hostedCountryCode = hostedCountryCode;
    }

    public String getTournamentDataSource() {
        return tournamentDataSource;
    }

    public void setTournamentDataSource(String tournamentDataSource) {
        this.tournamentDataSource = tournamentDataSource;
    }
}
