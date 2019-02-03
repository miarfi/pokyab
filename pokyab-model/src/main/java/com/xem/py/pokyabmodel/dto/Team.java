package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
//    @Basic(optional = false)
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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teamId")//cascade = CascadeType.ALL
    private Collection<TeamPerson> teamPersonCollection;
    @OneToMany( mappedBy = "awayTeamId")
    private Collection<Match> awayMatchCollection;
    @OneToMany( mappedBy = "homeTeamId")
    private Collection<Match> homeMatchCollection;
//    @OneToMany(mappedBy = "winnerTeamId")
//    private Collection<Match> matchCollection2;    
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
//    @Column(name = "TRAINING_ID")
//    private int traningId;   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TrainingPerson> trainingPersonCollection;

    @Transient
    private MultipartFile file;
    
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
    public Collection<TeamPerson> getTeamPersonVCollection() {
        return teamPersonCollection;
    }

    public void setTeamPersonVCollection(Collection<TeamPerson> teamPersonCollection) {
        this.teamPersonCollection = teamPersonCollection;
    }

    @XmlTransient
    public Collection<Match> getAwayMatchCollection() {
        return awayMatchCollection;
    }

    public void setAwayMatchCollection(Collection<Match> awayMatchCollection) {
        this.awayMatchCollection = awayMatchCollection;
    }

    @XmlTransient
    public Collection<Match> getHomeMatchCollection() {
        return homeMatchCollection;
    }

    public void setHomeMatchCollection(Collection<Match> homeMatchCollection) {
        this.homeMatchCollection = homeMatchCollection;
    }

//    @XmlTransient
//    public Collection<Match> getMatchCollection2() {
//        return matchCollection2;
//    }
//
//    public void setMatchCollection2(Collection<Match> matchCollection2) {
//        this.matchCollection2 = matchCollection2;
//    }

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

//    public int getTraningId() {
//        return traningId;
//    }
//
//    public void setTraningId(int traningId) {
//        this.traningId = traningId;
//    }
    
    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }
    
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", trainerPerId=" + trainerPerId + ", teamName=" + teamName + ", groupNumber=" + groupNumber + ", wins=" + wins + ", draws=" + draws + ", losts=" + losts + ", points=" + points + ", scores=" + scores + ", conceded=" + conceded + ", matchesPlayed=" + matchesPlayed + ", active=" + active + ", startDate=" + startDate + ", endDate=" + endDate + ", leagueId=" + leagueId + ", seasonId=" + seasonId + '}';
    }        

}
