
package com.xem.py.pokyabmodel.view;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "TRAINING_ACTIVITIES_V")
public class TrainingActivityV  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TRAIN_ACT_ID")
    private int trainActId;
    @Column(name = "ACTIVITY_NUMBER")
    private short activityNumber;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Column(name = "TOTAL_WEEKS")
    private short weeks;
    @Column(name = "TOTAL_DAYS")
    private short days;
    @Column(name = "REPEAT_FLAG")
    private Character repeatFlag;
    @Column(name = "MONDAY_FLAG")
    private Character mondayFlag;
    @Column(name = "THURSDAY_FLAG")
    private Character thursdayFlag;
    @Column(name = "WENESDAY_FLAG")
    private Character wednesdayFlag;
    @Column(name = "TUESDAY_FLAG")
    private Character tuesdayFlag;
    @Column(name = "FRIDAY_FLAG")
    private Character fridayFlag;
    @Column(name = "SATURDAY_FLAG")
    private Character saturdayFlag;
    @Column(name = "START_TIME")
    private String startTime;
    @Column(name = "END_TIME")
    private String endTime;
    @Column(name = "TRAINING_ID")
    private int trainingId;
    //Activity details
    @Column(name = "ACTIVITY_NAME")
    private String activityName;
    @Column(name = "METRIC_TYPE")
    private String metricType;
    @Column(name = "INSTRUCCIONS")
    private String instructions;
    @Column(name = "TOTAL_TIME")
    private long totalTime;
    @Column(name = "UOM_CODE")
    private String uomCode;
    @Column(name = "QUANTITY_MIN")
    private short quantityMin;
    @Column(name = "QUANTITY_MAX")
    private short quantityMax;

    public int getTrainActId() {
        return trainActId;
    }

    public short getActivityNumber() {
        return activityNumber;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public short getWeeks() {
        return weeks;
    }

    public short getDays() {
        return days;
    }

    public Character getRepeatFlag() {
        return repeatFlag;
    }

    public Character getMondayFlag() {
        return mondayFlag;
    }

    public Character getThursdayFlag() {
        return thursdayFlag;
    }

    public Character getWednesdayFlag() {
        return wednesdayFlag;
    }

    public Character getTuesdayFlag() {
        return tuesdayFlag;
    }

    public Character getFridayFlag() {
        return fridayFlag;
    }

    public Character getSaturdayFlag() {
        return saturdayFlag;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getMetricType() {
        return metricType;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public long getTotalTime() {
        return totalTime;
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
    
}
