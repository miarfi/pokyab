package com.xem.py.pokyabmodel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ACTIVITIES"
    ,uniqueConstraints={@UniqueConstraint(columnNames={"ACTIVITY_NAME"})}
)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private int activityId;
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
    private String instructions;
    @Column(name = "INSTRUCTIONS_TRAINER")
    private String instructionsTrainer;
    @Column(name = "GOALS")
    private String goals;
    @Column(name = "PARTICIPANT_NUMBER")
    private short participantNumber;
    @Column(name = "TOTAL_TIME")
    private long totalTime;
    @Column(name = "WAIT_TIME")
    private short waitTime;
//    @Basic(optional = false)
    @Column(name = "REPETITIONS")
    private short repetitions;
    @Basic(optional = false)
    @Column(name = "UOM_CODE")
    private String uomCode;
    @Basic(optional = false)
    @Column(name = "QUANTITY_MIN")
    private short quantityMin;
    @Column(name = "QUANTITY_MAX")
    private short quantityMax;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
    @JsonIgnore
    @OneToMany(mappedBy = "activityId")
    private Collection<TrainingActivity> trainingActivitieCollection;

    public Activity() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instruccions) {
        this.instructions = instruccions;
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

    public short getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(short participantNumber) {
        this.participantNumber = participantNumber;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public short getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(short waitTime) {
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

    public short getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(short quantityMax) {
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
    public String toString() {
        return "Activity{" + "activityId=" + activityId + ", activityType=" + activityType + ", metricType=" + metricType + ", activityName=" + activityName + ", instructions=" + instructions + ", instructionsTrainer=" + instructionsTrainer + ", goals=" + goals + ", participantNumber=" + participantNumber + ", totalTime=" + totalTime + ", waitTime=" + waitTime + ", repetitions=" + repetitions + ", uomCode=" + uomCode + ", quantityMin=" + quantityMin + ", quantityMax=" + quantityMax + ", requiredMaterial=" + requiredMaterial + ", dificultyLevel=" + dificultyLevel + ", active=" + active + ", startDate=" + startDate + ", endDate=" + endDate  + '}';
    }
}