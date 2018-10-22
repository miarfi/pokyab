
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
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component 
@Entity
@Table(name = "TRAININGS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAINING_ID")
    private Long trainingId;
    @Basic(optional = false)
    @Column(name = "TRAINING_NAME")
    private String trainingName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY_CODE")
    private String categoryCode;
    @Basic(optional = false)
    @Column(name = "GOALS")
    private String goals;
    @Basic(optional = false)
    @Column(name = "WEEKS")
    private short weeks;
    @Basic(optional = false)
    @Column(name = "DAYS")
    private short days;
    @Basic(optional = false)
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "REJECTED_REASON")
    private String rejectedReason;
    @Column(name = "CREATOR_PER_ID")
    private Long creatorPerId;
    @Column(name = "APPROVER_PER_ID")
    private Long approverPerId;
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
    @OneToMany(mappedBy = "trainingId")
    private Collection<TrainingActivity> trainingActivitieCollection;

    public Training() {
    }

//    public Training(Long trainingId) {
//        this.trainingId = trainingId;
//    }
//
//    public Training(Long trainingId, String trainingName, String goals, short weeks, short days, String statusCode, Character active, Date startDate) {
//        this.trainingId = trainingId;
//        this.trainingName = trainingName;
//        this.goals = goals;
//        this.weeks = weeks;
//        this.days = days;
//        this.statusCode = statusCode;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    public Long getCreatorPerId() {
        return creatorPerId;
    }

    public void setCreatorPerId(Long creatorPerId) {
        this.creatorPerId = creatorPerId;
    }

    public Long getApproverPerId() {
        return approverPerId;
    }

    public void setApproverPerId(Long approverPerId) {
        this.approverPerId = approverPerId;
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
    public Collection<TrainingActivity> getTrainingActivitieCollection() {
        return trainingActivitieCollection;
    }

    public void setTrainingActivitieCollection(Collection<TrainingActivity> trainingActivitieCollection) {
        this.trainingActivitieCollection = trainingActivitieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingId != null ? trainingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.trainingId == null && other.trainingId != null) || (this.trainingId != null && !this.trainingId.equals(other.trainingId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Training[ trainingId=" + trainingId + " ]";
//    }
    
}
