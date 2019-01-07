package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author miguel
 */

@Component
@Entity
@Immutable
@Table(name = "TEAM_PERSONS_V")
public class TeamPersonV implements Serializable {
    private static final long serialVersionUID = 1L;   
    
    @Id
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
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "START_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
    @Column(name = "TEAM_ID")
    private int teamId;
    @Column(name = "FULL_NAME")
    private String fullName;
//    @Column(name = "DATE_OF_BIRTH")
////    @Temporal(TemporalType.TIMESTAMP)    
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    private Date dateOfBirth;

    public int getTeamPersonId() {
        return teamPersonId;
    }

    public int getPersonId() {
        return personId;
    }

    public String getMemberType() {
        return memberType;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getPhisicCode() {
        return phisicCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public short getAge() {
        return age;
    }

    public short getHeight() {
        return height;
    }

    public short getWeight() {
        return weight;
    }

    public short getPlayerNumber() {
        return playerNumber;
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

    public int getTeamId() {
        return teamId;
    }

    public String getFullName() {
        return fullName;
    }
    
    
}
