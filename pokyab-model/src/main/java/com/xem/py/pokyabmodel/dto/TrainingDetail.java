package com.xem.py.pokyabmodel.dto;

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
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TrainingDetail.findAll", query = "SELECT t FROM TrainingDetail t")})
public class TrainingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAIN_DET_ID")
    private Long trainDetId;
    @Basic(optional = false)
    @Column(name = "TEAM_ID")
    private long teamId;
    @Column(name = "PERSON_ID")
    private Long personId;
    @Basic(optional = false)
    @Column(name = "TRAINING_ID")
    private long trainingId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private long activityId;
    @Basic(optional = false)
    @Column(name = "WEEKS")
    private short weeks;
    @Basic(optional = false)
    @Column(name = "DAYS")
    private short days;
    @Basic(optional = false)
    @Column(name = "TRAIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainDate;
    @Basic(optional = false)
    @Column(name = "START_TIME")
    private String startTime;
    @Basic(optional = false)
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "QUALIFICATION")
    private Short qualification;

    public TrainingDetail() {
    }

//    public TrainingDetail(Long trainDetId) {
//        this.trainDetId = trainDetId;
//    }
//
//    public TrainingDetail(Long trainDetId, long teamId, long trainingId, long activityId, short weeks, short days, Date trainDate, String startTime, String endTime) {
//        this.trainDetId = trainDetId;
//        this.teamId = teamId;
//        this.trainingId = trainingId;
//        this.activityId = activityId;
//        this.weeks = weeks;
//        this.days = days;
//        this.trainDate = trainDate;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }

    public Long getTrainDetId() {
        return trainDetId;
    }

    public void setTrainDetId(Long trainDetId) {
        this.trainDetId = trainDetId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(long trainingId) {
        this.trainingId = trainingId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Short getQualification() {
        return qualification;
    }

    public void setQualification(Short qualification) {
        this.qualification = qualification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainDetId != null ? trainDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingDetail)) {
            return false;
        }
        TrainingDetail other = (TrainingDetail) object;
        if ((this.trainDetId == null && other.trainDetId != null) || (this.trainDetId != null && !this.trainDetId.equals(other.trainDetId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.TrainingDetail[ trainDetId=" + trainDetId + " ]";
//    }
    
}
