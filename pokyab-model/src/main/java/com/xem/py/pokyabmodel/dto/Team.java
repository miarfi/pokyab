package com.xem.py.pokyabmodel.dto;

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
@Table(name = "TEAMS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAM_ID")
    private Long teamId;
    @Basic(optional = false)
    @Column(name = "TRAINER_PER_ID")
    private long trainerPerId;
    @Basic(optional = false)
    @Column(name = "TEAM_NAME")
    private String teamName;
    @Column(name = "GROUP_NUMBER")
    private Short groupNumber;
    @Column(name = "WINS")
    private Short wins;
    @Column(name = "DRAWS")
    private Short draws;
    @Column(name = "LOSTS")
    private Short losts;
    @Column(name = "POINTS")
    private Short points;
    @Column(name = "SCORES")
    private Short scores;
    @Column(name = "CONCEDED")
    private Short conceded;
    @Column(name = "MATCHES_PLAYED")
    private Short matchesPlayed;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TeamPerson> teamPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "awayTeamId")
    private Collection<Match> matchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "homeTeamId")
    private Collection<Match> matchCollection1;
    @OneToMany(mappedBy = "winnerTeamId")
    private Collection<Match> matchCollection2;
    @JoinColumn(name = "LEAGUE_ID", referencedColumnName = "LEAGUE_ID")
    @ManyToOne(optional = false)
    private League leagueId;
    @JoinColumn(name = "SEASON_ID", referencedColumnName = "SEASON_ID")
    @ManyToOne(optional = false)
    private Season seasonId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TrainingPerson> trainingPersonCollection;

    public Team() {
    }

//    public Team(Long teamId) {
//        this.teamId = teamId;
//    }
//
//    public Team(Long teamId, long trainerPerId, String teamName, Character active, Date startDate) {
//        this.teamId = teamId;
//        this.trainerPerId = trainerPerId;
//        this.teamName = teamName;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public long getTrainerPerId() {
        return trainerPerId;
    }

    public void setTrainerPerId(long trainerPerId) {
        this.trainerPerId = trainerPerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Short getGroup() {
        return groupNumber;
    }

    public void setGroup(Short group) {
        this.groupNumber = group;
    }

    public Short getWins() {
        return wins;
    }

    public void setWins(Short wins) {
        this.wins = wins;
    }

    public Short getDraws() {
        return draws;
    }

    public void setDraws(Short draws) {
        this.draws = draws;
    }

    public Short getLosts() {
        return losts;
    }

    public void setLosts(Short losts) {
        this.losts = losts;
    }

    public Short getPoints() {
        return points;
    }

    public void setPoints(Short points) {
        this.points = points;
    }

    public Short getScores() {
        return scores;
    }

    public void setScores(Short scores) {
        this.scores = scores;
    }

    public Short getConceded() {
        return conceded;
    }

    public void setConceded(Short conceded) {
        this.conceded = conceded;
    }

    public Short getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Short matchesPlayed) {
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
    public Collection<TeamPerson> getTeamPersonCollection() {
        return teamPersonCollection;
    }

    public void setTeamPersonCollection(Collection<TeamPerson> teamPersonCollection) {
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

    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamId != null ? teamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.teamId == null && other.teamId != null) || (this.teamId != null && !this.teamId.equals(other.teamId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Team[ teamId=" + teamId + " ]";
//    }
    
}
