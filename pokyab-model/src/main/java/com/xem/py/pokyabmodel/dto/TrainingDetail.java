package com.xem.py.pokyabmodel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component 
@Entity
@Table(name = "TRAINING_DETAILS")

public class TrainingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAIN_DET_ID")
    private int trainDetId;
    @Basic(optional = false)
    @Column(name = "TEAM_ID")
    private long teamId;
    @Column(name = "PERSON_ID")
    private int personId;
    @Basic(optional = false)
    @Column(name = "TRAINING_ID")
    private int trainingId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private int activityId;
    @Basic(optional = false)
    @Column(name = "WEEKS")
    private short weeks;
    @Basic(optional = false)
    @Column(name = "DAYS")
    private short days;
    @Basic(optional = false)
    @Column(name = "TRAIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date trainDate;
    @Basic(optional = false)
    @Column(name = "START_TIME")
    private String startTime;
    @Basic(optional = false)
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "QUALIFICATION")
    private short qualification;

    public TrainingDetail() {
    }


    public int getTrainDetId() {
        return trainDetId;
    }

    public void setTrainDetId(int trainDetId) {
        this.trainDetId = trainDetId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public short getWeeks() {
        return weeks;
    }

    public void setWeeks(short weeks) {
        this.weeks = weeks;
    }

    public short getDays() {
        return days;
    }

    public void setDays(short days) {
        this.days = days;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public short getQualification() {
        return qualification;
    }

    public void setQualification(short qualification) {
        this.qualification = qualification;
    }
    
}
