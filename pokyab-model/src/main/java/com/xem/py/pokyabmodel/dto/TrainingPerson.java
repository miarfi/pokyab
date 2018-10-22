package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRAINING_PERSONS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TrainingPerson.findAll", query = "SELECT t FROM TrainingPerson t")})
public class TrainingPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAIN_PER_ID")
    private Long trainPerId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private long activityId;
    @Basic(optional = false)
    @Column(name = "TRAIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainDate;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Basic(optional = false)
    @Column(name = "START_TIME")
    private String startTime;
    @Basic(optional = false)
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "REAL_QUANTITY")
    private Short realQuantity;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "QUALIFICATION")
    private Short qualification;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "TEAM_PERSON_ID")
    @ManyToOne
    private TeamPerson personId;
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID")
    @ManyToOne(optional = false)
    private Team teamId;
    @JoinColumn(name = "TRAIN_ACT_ID", referencedColumnName = "TRAIN_ACT_ID")
    @ManyToOne(optional = false)
    private TrainingActivity trainActId;

    public TrainingPerson() {
    }

//    public TrainingPerson(Long trainPerId) {
//        this.trainPerId = trainPerId;
//    }
//
//    public TrainingPerson(Long trainPerId, long activityId, Date trainDate, String startTime, String endTime) {
//        this.trainPerId = trainPerId;
//        this.activityId = activityId;
//        this.trainDate = trainDate;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }

    public Long getTrainPerId() {
        return trainPerId;
    }

    public void setTrainPerId(Long trainPerId) {
        this.trainPerId = trainPerId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Short getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(Short realQuantity) {
        this.realQuantity = realQuantity;
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

    public TeamPerson getPersonId() {
        return personId;
    }

    public void setPersonId(TeamPerson personId) {
        this.personId = personId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public TrainingActivity getTrainActId() {
        return trainActId;
    }

    public void setTrainActId(TrainingActivity trainActId) {
        this.trainActId = trainActId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainPerId != null ? trainPerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingPerson)) {
            return false;
        }
        TrainingPerson other = (TrainingPerson) object;
        if ((this.trainPerId == null && other.trainPerId != null) || (this.trainPerId != null && !this.trainPerId.equals(other.trainPerId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.TrainingPerson[ trainPerId=" + trainPerId + " ]";
//    }
    
}
