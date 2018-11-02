package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arria
 */
@Entity
@Table(name = "TRAINING_ACTIVITIES")
public class TrainingActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAIN_ACT_ID")
    private int trainActId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_NUMBER")
    private short activityNumber;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Basic(optional = false)
    //Todo Renombrar en modelo db
    @Column(name = "TOTAL_WEEKS")
    private short weeks;
    //@Basic(optional = false)
    //Todo Renombrar en modelo db
    @Column(name = "TOTAL_DAYS")
    private short days;
    @Column(name = "REPEAT_FLAG")
    private Character repeatFlag;
    @Column(name = "MONDAY_FLAG")
    private Character mondayFlag;
    @Column(name = "THURSDAY_FLAG")
    private Character thursdayFlag;
    //Todo Renombrar en modelo db
    @Column(name = "WENESDAY_FLAG")
    private Character wednesdayFlag;
    @Column(name = "TUESDAY_FLAG")
    private Character tuesdayFlag;
    @Column(name = "FRIDAY_FLAG")
    private Character fridayFlag;
    @Column(name = "SATURDAY_FLAG")
    private Character saturdayFlag;
    @Basic(optional = false)
    @Column(name = "START_TIME")
    private String startTime;
    @Basic(optional = false)
    @Column(name = "END_TIME")
    private String endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainActId")
    private Collection<TrainingPerson> trainingPersonCollection;
//    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
//    @ManyToOne
//    private Activity activityId;
//    @JoinColumn(name = "TRAINING_ID", referencedColumnName = "TRAINING_ID")
//    @ManyToOne
//    private Training trainingId;
    @Column(name = "ACTIVITY_ID")
    private int activityId;
    @Column(name = "TRAINING_ID")
    private int trainingId;

    public TrainingActivity() {
    }

    public int getTrainActId() {
        return trainActId;
    }

    public void setTrainActId(int trainActId) {
        this.trainActId = trainActId;
    }

    public short getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(short activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public short getWeeks() {
        return weeks;
    }

    public void setWeeks(short totalWeeks) {
        this.weeks = totalWeeks;
    }

    public short getDays() {
        return days;
    }

    public void setDays(short totalDays) {
        this.days = totalDays;
    }

    public Character getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Character repeatFlag) {
        this.repeatFlag = repeatFlag;
    }

    public Character getMondayFlag() {
        return mondayFlag;
    }

    public void setMondayFlag(Character mondayFlag) {
        this.mondayFlag = mondayFlag;
    }

    public Character getThursdayFlag() {
        return thursdayFlag;
    }

    public void setThursdayFlag(Character thursdayFlag) {
        this.thursdayFlag = thursdayFlag;
    }

    public Character getWednesdayFlag() {
        return wednesdayFlag;
    }

    public void setWednesdayFlag(Character wenesdayFlag) {
        this.wednesdayFlag = wenesdayFlag;
    }

    public Character getTuesdayFlag() {
        return tuesdayFlag;
    }

    public void setTuesdayFlag(Character tuesdayFlag) {
        this.tuesdayFlag = tuesdayFlag;
    }

    public Character getFridayFlag() {
        return fridayFlag;
    }

    public void setFridayFlag(Character fridayFlag) {
        this.fridayFlag = fridayFlag;
    }

    public Character getSaturdayFlag() {
        return saturdayFlag;
    }

    public void setSaturdayFlag(Character saturdayFlag) {
        this.saturdayFlag = saturdayFlag;
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
    
    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

//    public Activity getActivityId() {
//        return activityId;
//    }
//
//    public void setActivityId(Activity activityId) {
//        this.activityId = activityId;
//    }
//
//    public Training getTrainingId() {
//        return trainingId;
//    }
//    public void setTrainingId(Training trainingId) {
//        this.trainingId = trainingId;
//    }
    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getTrainingId() {
        return trainingId;
    }


}
