
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
@Table(name = "ACTIVITIES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Activitie.findAll", query = "SELECT a FROM Activitie a")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private Long activityId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_TYPE")
    private String activityType;
    @Column(name = "METRIC_TYPE")
    private String metricType;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
    @Basic(optional = false)
    @Column(name = "INSTRUCCIONS")
    private String instruccions;
    @Column(name = "INSTRUCTIONS_TRAINER")
    private String instructionsTrainer;
    @Column(name = "GOALS")
    private String goals;
    @Column(name = "PARTICIPANT_NUMBER")
    private Short participantNumber;
    @Column(name = "TOTAL_TIME")
    private Short totalTime;
    @Column(name = "WAIT_TIME")
    private Short waitTime;
    @Basic(optional = false)
    @Column(name = "REPETITIONS")
    private short repetitions;
    @Basic(optional = false)
    @Column(name = "UOM_CODE")
    private String uomCode;
    @Basic(optional = false)
    @Column(name = "QUANTITY_MIN")
    private short quantityMin;
    @Column(name = "QUANTITY_MAX")
    private Short quantityMax;
    @Column(name = "REQUIRED_MATERIAL")
    private String requiredMaterial;
    @Column(name = "DIFICULTY_LEVEL")
    private String dificultyLevel;
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
    @OneToMany(mappedBy = "activityId")
    private Collection<TrainingActivity> trainingActivitieCollection;

    public Activity() {
    }

//    public Activity(Long activityId) {
//        this.activityId = activityId;
//    }
//
//    public Activity(Long activityId, String activityType, String activityName, String instruccions, short repetitions, String uomCode, short quantityMin, Character active, Date startDate) {
//        this.activityId = activityId;
//        this.activityType = activityType;
//        this.activityName = activityName;
//        this.instruccions = instruccions;
//        this.repetitions = repetitions;
//        this.uomCode = uomCode;
//        this.quantityMin = quantityMin;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(String instruccions) {
        this.instruccions = instruccions;
    }

    public String getInstructionsTrainer() {
        return instructionsTrainer;
    }

    public void setInstructionsTrainer(String instructionsTrainer) {
        this.instructionsTrainer = instructionsTrainer;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Short getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(Short participantNumber) {
        this.participantNumber = participantNumber;
    }

    public Short getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Short totalTime) {
        this.totalTime = totalTime;
    }

    public Short getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Short waitTime) {
        this.waitTime = waitTime;
    }

    public short getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(short repetitions) {
        this.repetitions = repetitions;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public short getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(short quantityMin) {
        this.quantityMin = quantityMin;
    }

    public Short getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(Short quantityMax) {
        this.quantityMax = quantityMax;
    }

    public String getRequiredMaterial() {
        return requiredMaterial;
    }

    public void setRequiredMaterial(String requiredMaterial) {
        this.requiredMaterial = requiredMaterial;
    }

    public String getDificultyLevel() {
        return dificultyLevel;
    }

    public void setDificultyLevel(String dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
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
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Activitie[ activityId=" + activityId + " ]";
//    }
    
}
