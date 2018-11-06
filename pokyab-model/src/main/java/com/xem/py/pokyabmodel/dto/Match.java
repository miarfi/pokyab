package com.xem.py.pokyabmodel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "MATCHS")
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATCH_ID")
    private int matchId;
    @Column(name = "ROUND_CODE")
    private String roundCode;
    @Column(name = "MATCH_TYPE_CODE")
    private String matchTypeCode;
    @Column(name = "MATCH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date matchDate;
    @Column(name = "MATCH_TIME")
    private String matchTime;
    @Column(name = "REFEREE_PERSON_ID")
    private int refereePersonId;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "MATCH_LOCATION")
    private String matchLocation;
    @Column(name = "HOME_SCORE")
    private short homeScore;
    @Column(name = "AWAY_SCORE")
    private short awayScore;
    @JoinColumn(name = "LEAGUE_ID", referencedColumnName = "LEAGUE_ID")
    @ManyToOne(optional = false)
    private League leagueId;
    @JoinColumn(name = "SEASON_ID", referencedColumnName = "SEASON_ID")
    @ManyToOne(optional = false)
    private Season seasonId;
    @JoinColumn(name = "AWAY_TEAM_ID", referencedColumnName = "TEAM_ID")
    @ManyToOne(optional = false)
    private Team awayTeamId;
    @JoinColumn(name = "HOME_TEAM_ID", referencedColumnName = "TEAM_ID")
    @ManyToOne(optional = false)
    private Team homeTeamId;
    @JoinColumn(name = "WINNER_TEAM_ID", referencedColumnName = "TEAM_ID")
    @ManyToOne
    private Team winnerTeamId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchId")
    private Collection<MatchPlayer> matchPlayerCollection;

    public Match() {
    }

//    public Match(int matchId) {
//        this.matchId = matchId;
//    }
//
//    public Match(int matchId, String status) {
//        this.matchId = matchId;
//        this.status = status;
//    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getRoundCode() {
        return roundCode;
    }

    public void setRoundCode(String roundCode) {
        this.roundCode = roundCode;
    }

    public String getMatchTypeCode() {
        return matchTypeCode;
    }

    public void setMatchTypeCode(String matchTypeCode) {
        this.matchTypeCode = matchTypeCode;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public int getRefereePersonId() {
        return refereePersonId;
    }

    public void setRefereePersonId(int refereePersonId) {
        this.refereePersonId = refereePersonId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public void setMatchLocation(String matchLocation) {
        this.matchLocation = matchLocation;
    }

    public short getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(short homeScore) {
        this.homeScore = homeScore;
    }

    public short getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(short awayScore) {
        this.awayScore = awayScore;
    }

    public League getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(League leagueId) {
        this.leagueId = leagueId;
    }

    public Season getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Season seasonId) {
        this.seasonId = seasonId;
    }

    public Team getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Team awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public Team getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Team homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Team getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(Team winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    @XmlTransient
    public Collection<MatchPlayer> getMatchPlayerCollection() {
        return matchPlayerCollection;
    }

    public void setMatchPlayerCollection(Collection<MatchPlayer> matchPlayerCollection) {
        this.matchPlayerCollection = matchPlayerCollection;
    }   
    
}
