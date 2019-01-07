package com.xem.py.pokyabmodel.dto;

import com.xem.py.pokyabmodel.view.TeamPersonV;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "TEAMS"
    ,uniqueConstraints={@UniqueConstraint(columnNames={"TEAM_NAME"})}
)

public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAM_ID")
    private int teamId;
    @Basic(optional = false)
    @Column(name = "TRAINER_PER_ID")
    private int trainerPerId;
    @Basic(optional = false)
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
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")    
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")    
    private Date endDate; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TeamPersonV> teamPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "awayTeamId")
    private Collection<Match> matchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "homeTeamId")
    private Collection<Match> matchCollection1;
    @OneToMany(mappedBy = "winnerTeamId")
    private Collection<Match> matchCollection2;    
//    @JoinColumn(name = "LEAGUE_ID", referencedColumnName = "LEAGUE_ID")
//    @ManyToOne(optional = false)
//    private League leagueId;
//    @JoinColumn(name = "SEASON_ID", referencedColumnName = "SEASON_ID")
//    @ManyToOne(optional = false)
//    private Season seasonId;
    @Column(name = "LEAGUE_ID")
    private int leagueId;   
    @Column(name = "SEASON_ID")
    private int seasonId;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TrainingPerson> trainingPersonCollection;

    public Team() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTrainerPerId() {
        return trainerPerId;
    }

    public void setTrainerPerId(int trainerPerId) {
        this.trainerPerId = trainerPerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public short getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(short groupNumber) {
        this.groupNumber = groupNumber;
    }
    
    public short getWins() {
        return wins;
    }

    public void setWins(short wins) {
        this.wins = wins;
    }

    public short getDraws() {
        return draws;
    }

    public void setDraws(short draws) {
        this.draws = draws;
    }

    public short getLosts() {
        return losts;
    }

    public void setLosts(short losts) {
        this.losts = losts;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    public short getScores() {
        return scores;
    }

    public void setScores(short scores) {
        this.scores = scores;
    }

    public short getConceded() {
        return conceded;
    }

    public void setConceded(short conceded) {
        this.conceded = conceded;
    }

    public short getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(short matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Collection<TeamPersonV> getTeamPersonVCollection() {
        return teamPersonCollection;
    }

    public void setTeamPersonVCollection(Collection<TeamPersonV> teamPersonCollection) {
        this.teamPersonCollection = teamPersonCollection;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection() {
        return matchCollection;
    }

    public void setMatchCollection(Collection<Match> matchCollection) {
        this.matchCollection = matchCollection;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection1() {
        return matchCollection1;
    }

    public void setMatchCollection1(Collection<Match> matchCollection1) {
        this.matchCollection1 = matchCollection1;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection2() {
        return matchCollection2;
    }

    public void setMatchCollection2(Collection<Match> matchCollection2) {
        this.matchCollection2 = matchCollection2;
    }

//    public League getLeagueId() {
//        return leagueId;
//    }
//
//    public void setLeagueId(League leagueId) {
//        this.leagueId = leagueId;
//    }
//
//    public Season getSeasonId() {
//        return seasonId;
//    }
//
//    public void setSeasonId(Season seasonId) {
//        this.seasonId = seasonId;
//    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
    
    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }
    
    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

}
