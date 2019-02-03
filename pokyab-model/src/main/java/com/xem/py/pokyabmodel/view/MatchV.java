
package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "MATCHS_V")
public class MatchV implements Serializable{ 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "STATUS")
    private String status;
    @Column(name = "MATCH_LOCATION")
    private String matchLocation;
    @Column(name = "HOME_SCORE")
    private short homeScore;
    @Column(name = "AWAY_SCORE")
    private short awayScore;
    @Column(name = "LEAGUE_ID")
    private int leagueId;
    @Column(name = "SEASON_ID")
    private int seasonId;
    @Column(name = "AWAY_TEAM_ID")
    private int awayTeamId;
    @Column(name = "HOME_TEAM_ID")
    private int homeTeamId;
    @Column(name = "WINNER_TEAM_ID")
    private int winnerTeamId;
    @Column(name = "LEAGUE_NAME")
    private String leagueName;
    @Column(name = "SEASON_NAME")
    private String seasonName;
    @Column(name = "AWAY_TEAM_NAME")
    private String awayTeamName;
    @Column(name = "HOME_TEAM_NAME")
    private String homeTeamName;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getRoundCode() {
        return roundCode;
    }

    public String getMatchTypeCode() {
        return matchTypeCode;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public int getRefereePersonId() {
        return refereePersonId;
    }

    public String getStatus() {
        return status;
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public short getHomeScore() {
        return homeScore;
    }

    public short getAwayScore() {
        return awayScore;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }
    
    
}
