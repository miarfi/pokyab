
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arria
 */
@Entity
@Table(name = "TRAINING_ACTIVITIES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TrainingActivitie.findAll", query = "SELECT t FROM TrainingActivitie t")})
public class TrainingActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAIN_ACT_ID")
    private Long trainActId;
    @Basic(optional = false)
    @Column(name = "ACTIVITY_NUMBER")
    private short activityNumber;
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Basic(optional = false)
    @Column(name = "TOTAL_WEEKS")
    private short totalWeeks;
    @Basic(optional = false)
    @Column(name = "TOTAL_DAYS")
    private short totalDays;
    @Column(name = "REPEAT_FLAG")
    private Character repeatFlag;
    @Column(name = "MONDAY_FLAG")
    private Character mondayFlag;
    @Column(name = "THURSDAY_FLAG")
    private Character thursdayFlag;
    @Column(name = "WENESDAY_FLAG")
    private Character wenesdayFlag;
    @Column(name = "TUESDAY_FLAG")
    private Character tuesdayFlag;
    @Column(name = "FRIDAY_FLAG")
    private Character fridayFlag;
    @Column(name = "SATURDAY_FLAG")
    private Character saturdayFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainActId")
    private Collection<TrainingPerson> trainingPersonCollection;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne
    private Activity activityId;
    @JoinColumn(name = "TRAINING_ID", referencedColumnName = "TRAINING_ID")
    @ManyToOne
    private Training trainingId;

    public TrainingActivity() {
    }

//    public TrainingActivity(Long trainActId) {
//        this.trainActId = trainActId;
//    }
//
//    public TrainingActivity(Long trainActId, short activityNumber, short totalWeeks, short totalDays) {
//        this.trainActId = trainActId;
//        this.activityNumber = activityNumber;
//        this.totalWeeks = totalWeeks;
//        this.totalDays = totalDays;
//    }

    public Long getTrainActId() {
        return trainActId;
    }

    public void setTrainActId(Long trainActId) {
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

    public short getTotalWeeks() {
        return totalWeeks;
    }

    public void setTotalWeeks(short totalWeeks) {
        this.totalWeeks = totalWeeks;
    }

    public short getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(short totalDays) {
        this.totalDays = totalDays;
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

    public Character getWenesdayFlag() {
        return wenesdayFlag;
    }

    public void setWenesdayFlag(Character wenesdayFlag) {
        this.wenesdayFlag = wenesdayFlag;
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

    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public Training getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Training trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainActId != null ? trainActId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingActivity)) {
            return false;
        }
        TrainingActivity other = (TrainingActivity) object;
        if ((this.trainActId == null && other.trainActId != null) || (this.trainActId != null && !this.trainActId.equals(other.trainActId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.TrainingActivitie[ trainActId=" + trainActId + " ]";
//    }
    
}
