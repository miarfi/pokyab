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
public class MatchPlayer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATCH_PLAYER_ID")
    private int matchPlayerId;
    @Column(name = "TEAM_PERSON_ID")
    private int teamPersonId;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Column(name = "TIME_ENTER")
    private String timeEnter;
    @Column(name = "TIME_OUT")
    private String timeOut;
    @Column(name = "TIME_PLAYED")
    private short timePlayed;
    @Column(name = "SCORE1")
    private short score1;
    @Column(name = "SCORE2")
    private short score2;
    @Column(name = "SCORE3")
    private short score3;
    @Column(name = "SCORE4")
    private short score4;
    @Column(name = "SCORE5")
    private short score5;
    @Column(name = "AMONESTATIONS1")
    private short amonestations1;
    @Column(name = "AMONESTATIONS2")
    private short amonestations2;
    @Column(name = "AMONESTATIONS3")
    private short amonestations3;
    @Column(name = "ASSISTANCES1")
    private short assistances1;
    @Column(name = "ASSISTANCES2")
    private short assistances2;
    @Column(name = "ASSISTANCES3")
    private short assistances3;
    @JoinColumn(name = "MATCH_ID", referencedColumnName = "MATCH_ID")
    @ManyToOne(optional = false)
    private Match matchId;

    public MatchPlayer() {
    }

//    public MatchPlayer(int matchPlayerId) {
//        this.matchPlayerId = matchPlayerId;
//    }

    public int getMatchPlayerId() {
        return matchPlayerId;
    }

    public void setMatchPlayerId(int matchPlayerId) {
        this.matchPlayerId = matchPlayerId;
    }

    public int getTeamPersonId() {
        return teamPersonId;
    }

    public void setTeamPersonId(int teamPersonId) {
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

    public short getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(short timePlayed) {
        this.timePlayed = timePlayed;
    }

    public short getScore1() {
        return score1;
    }

    public void setScore1(short score1) {
        this.score1 = score1;
    }

    public short getScore2() {
        return score2;
    }

    public void setScore2(short score2) {
        this.score2 = score2;
    }

    public short getScore3() {
        return score3;
    }

    public void setScore3(short score3) {
        this.score3 = score3;
    }

    public short getScore4() {
        return score4;
    }

    public void setScore4(short score4) {
        this.score4 = score4;
    }

    public short getScore5() {
        return score5;
    }

    public void setScore5(short score5) {
        this.score5 = score5;
    }

    public short getAmonestations1() {
        return amonestations1;
    }

    public void setAmonestations1(short amonestations1) {
        this.amonestations1 = amonestations1;
    }

    public short getAmonestations2() {
        return amonestations2;
    }

    public void setAmonestations2(short amonestations2) {
        this.amonestations2 = amonestations2;
    }

    public short getAmonestations3() {
        return amonestations3;
    }

    public void setAmonestations3(short amonestations3) {
        this.amonestations3 = amonestations3;
    }

    public short getAssistances1() {
        return assistances1;
    }

    public void setAssistances1(short assistances1) {
        this.assistances1 = assistances1;
    }

    public short getAssistances2() {
        return assistances2;
    }

    public void setAssistances2(short assistances2) {
        this.assistances2 = assistances2;
    }

    public short getAssistances3() {
        return assistances3;
    }

    public void setAssistances3(short assistances3) {
        this.assistances3 = assistances3;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
        this.matchId = matchId;
    } 
    
}
