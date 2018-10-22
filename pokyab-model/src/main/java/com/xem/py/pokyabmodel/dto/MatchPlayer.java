package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "MATCH_PLAYERS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "MatchPlayer.findAll", query = "SELECT m FROM MatchPlayer m")})
public class MatchPlayer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATCH_PLAYER_ID")
    private Long matchPlayerId;
    @Column(name = "TEAM_PERSON_ID")
    private Long teamPersonId;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Column(name = "TIME_ENTER")
    private String timeEnter;
    @Column(name = "TIME_OUT")
    private String timeOut;
    @Column(name = "TIME_PLAYED")
    private Short timePlayed;
    @Column(name = "SCORE1")
    private Short score1;
    @Column(name = "SCORE2")
    private Short score2;
    @Column(name = "SCORE3")
    private Short score3;
    @Column(name = "SCORE4")
    private Short score4;
    @Column(name = "SCORE5")
    private Short score5;
    @Column(name = "AMONESTATIONS1")
    private Short amonestations1;
    @Column(name = "AMONESTATIONS2")
    private Short amonestations2;
    @Column(name = "AMONESTATIONS3")
    private Short amonestations3;
    @Column(name = "ASSISTANCES1")
    private Short assistances1;
    @Column(name = "ASSISTANCES2")
    private Short assistances2;
    @Column(name = "ASSISTANCES3")
    private Short assistances3;
    @JoinColumn(name = "MATCH_ID", referencedColumnName = "MATCH_ID")
    @ManyToOne(optional = false)
    private Match matchId;

    public MatchPlayer() {
    }

//    public MatchPlayer(Long matchPlayerId) {
//        this.matchPlayerId = matchPlayerId;
//    }

    public Long getMatchPlayerId() {
        return matchPlayerId;
    }

    public void setMatchPlayerId(Long matchPlayerId) {
        this.matchPlayerId = matchPlayerId;
    }

    public Long getTeamPersonId() {
        return teamPersonId;
    }

    public void setTeamPersonId(Long teamPersonId) {
        this.teamPersonId = teamPersonId;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getTimeEnter() {
        return timeEnter;
    }

    public void setTimeEnter(String timeEnter) {
        this.timeEnter = timeEnter;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Short getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(Short timePlayed) {
        this.timePlayed = timePlayed;
    }

    public Short getScore1() {
        return score1;
    }

    public void setScore1(Short score1) {
        this.score1 = score1;
    }

    public Short getScore2() {
        return score2;
    }

    public void setScore2(Short score2) {
        this.score2 = score2;
    }

    public Short getScore3() {
        return score3;
    }

    public void setScore3(Short score3) {
        this.score3 = score3;
    }

    public Short getScore4() {
        return score4;
    }

    public void setScore4(Short score4) {
        this.score4 = score4;
    }

    public Short getScore5() {
        return score5;
    }

    public void setScore5(Short score5) {
        this.score5 = score5;
    }

    public Short getAmonestations1() {
        return amonestations1;
    }

    public void setAmonestations1(Short amonestations1) {
        this.amonestations1 = amonestations1;
    }

    public Short getAmonestations2() {
        return amonestations2;
    }

    public void setAmonestations2(Short amonestations2) {
        this.amonestations2 = amonestations2;
    }

    public Short getAmonestations3() {
        return amonestations3;
    }

    public void setAmonestations3(Short amonestations3) {
        this.amonestations3 = amonestations3;
    }

    public Short getAssistances1() {
        return assistances1;
    }

    public void setAssistances1(Short assistances1) {
        this.assistances1 = assistances1;
    }

    public Short getAssistances2() {
        return assistances2;
    }

    public void setAssistances2(Short assistances2) {
        this.assistances2 = assistances2;
    }

    public Short getAssistances3() {
        return assistances3;
    }

    public void setAssistances3(Short assistances3) {
        this.assistances3 = assistances3;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
        this.matchId = matchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matchPlayerId != null ? matchPlayerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatchPlayer)) {
            return false;
        }
        MatchPlayer other = (MatchPlayer) object;
        if ((this.matchPlayerId == null && other.matchPlayerId != null) || (this.matchPlayerId != null && !this.matchPlayerId.equals(other.matchPlayerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.xem.py.pokyabmodel.dto.MatchPlayer[ matchPlayerId=" + matchPlayerId + " ]";
    }
    
}
