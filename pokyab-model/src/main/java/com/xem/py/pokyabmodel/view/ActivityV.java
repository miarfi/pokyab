package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "ACTIVITIES_V")
public class ActivityV implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  
    @Column(name = "ACTIVITY_ID")
    private int activityId;
    @Column(name = "ACTIVITY_TYPE")
    private String activityType;
    @Column(name = "METRIC_TYPE")
    private String metricType;
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
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
    @Column(name = "REPETITIONS")
    private short repetitions;
    @Column(name = "UOM_CODE")
    private String uomCode;    
    @Column(name = "QUANTITY_MIN")
    private short quantityMin;
    @Column(name = "QUANTITY_MAX")
    private short quantityMax;
    @Column(name = "REQUIRED_MATERIAL")
    private String requiredMaterial;
    @Column(name = "DIFICULTY_LEVEL")
    private String dificultyLevel;    
    @Column(name = "ACTIVE")
    private String active;    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getActivityId() {
        return activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getMetricType() {
        return metricType;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getInstructionsTrainer() {
        return instructionsTrainer;
    }

    public String getGoals() {
        return goals;
    }

    public short getParticipantNumber() {
        return participantNumber;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public short getWaitTime() {
        return waitTime;
    }

    public short getRepetitions() {
        return repetitions;
    }

    public String getUomCode() {
        return uomCode;
    }

    public short getQuantityMin() {
        return quantityMin;
    }

    public short getQuantityMax() {
        return quantityMax;
    }

    public String getRequiredMaterial() {
        return requiredMaterial;
    }

    public String getDificultyLevel() {
        return dificultyLevel;
    }

    public String getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    
}
