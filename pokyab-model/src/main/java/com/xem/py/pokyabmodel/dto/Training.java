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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component 
@Entity
@Table(name = "TRAININGS"
        ,uniqueConstraints={@UniqueConstraint(columnNames={"TRAINING_NAME"})}
)
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAINING_ID")
    private int trainingId;
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
    private int creatorPerId;
    @Column(name = "APPROVER_PER_ID")
    private int approverPerId;
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
    @OneToMany(mappedBy = "trainingId")
    private Collection<TrainingActivity> trainingActivitieCollection;

    public Training() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
        this.statusCode = "NEW";
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
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

    public int getCreatorPerId() {
        return creatorPerId;
    }

    public void setCreatorPerId(int creatorPerId) {
        this.creatorPerId = creatorPerId;
    }

    public int getApproverPerId() {
        return approverPerId;
    }

    public void setApproverPerId(int approverPerId) {
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
    
}
