package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "TEAM_PERSONS")
public class TeamPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAM_PERSON_ID")
    private int teamPersonId;
    @Column(name = "PERSON_ID")
    private int personId;
    @Column(name = "MEMBER_TYPE")
    private String memberType;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Column(name = "PHISIC_CODE")
    private String phisicCode;
    @Basic(optional = false)  
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "AGE")
    private short age;
    @Column(name = "HEIGHT")
    private short height;
    @Column(name = "WEIGHT")
    private short weight;
    @Column(name = "PLAYER_NUMBER")
    private short playerNumber;
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
//    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID")
//    @ManyToOne /@JoinColumn/(optional = false)
//    private Team teamId;
    @Column(name = "TEAM_ID")
    private int teamId;
    @OneToMany(mappedBy = "personId")
    private Collection<TrainingPerson> trainingPersonCollection;

    public TeamPerson() {
    }

    public int getTeamPersonId() {
        return teamPersonId;
    }

    public void setTeamPersonId(int teamPersonId) {
        this.teamPersonId = teamPersonId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }    

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPhisicCode() {
        return phisicCode;
    }

    public void setPhisicCode(String phisicCode) {
        this.phisicCode = phisicCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public short getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(short playerNumber) {
        this.playerNumber = playerNumber;
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }        

    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

    
}
