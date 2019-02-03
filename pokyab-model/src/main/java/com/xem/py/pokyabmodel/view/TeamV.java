package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "TEAMS_V")
public class TeamV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "TEAM_ID")
    private int teamId;       
    @Column(name = "TEAM_NAME")
    private String teamName;
    @Column(name = "GROUP_NUMBER")
    private short groupNumber;
    @Column(name = "WINS")
    private short wins;
    @Column(name = "DRAWS")
    private short draws;
    @Column(name = "LOSTS")
    private short losts;
    @Column(name = "POINTS")
    private short points;
    @Column(name = "SCORES")
    private short scores;
    @Column(name = "CONCEDED")
    private short conceded;
    @Column(name = "MATCHES_PLAYED")
    private short matchesPlayed;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "START_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate; 
    //
    @Column(name = "LEAGUE_NAME")
    private String leagueName;   
    @Column(name = "SEASON_NAME")
    private String seasonName;    
    @Column(name = "TRAINER_PER_NAME")
    private String trainerPerName;   
    @Column(name= "CATEGORY_CODE")
    private String categoryCode;

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public short getGroupNumber() {
        return groupNumber;
    }

    public short getWins() {
        return wins;
    }

    public short getDraws() {
        return draws;
    }

    public short getLosts() {
        return losts;
    }

    public short getPoints() {
        return points;
    }

    public short getScores() {
        return scores;
    }

    public short getConceded() {
        return conceded;
    }

    public short getMatchesPlayed() {
        return matchesPlayed;
    }

    public Character getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getTrainerPerName() {
        return trainerPerName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }
}
