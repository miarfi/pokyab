package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "TRAININGS_V")
public class TrainingV implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "TRAINING_ID")
    private int trainingId;    
    @Column(name = "TRAINING_NAME")
    private String trainingName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY_CODE")
    private String categoryCode;    
    @Column(name = "GOALS")
    private String goals;   
    @Column(name = "WEEKS")
    private short weeks;
    @Basic(optional = false)
    @Column(name = "DAYS")
    private short days;    
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "REJECTED_REASON")
    private String rejectedReason;
    @Column(name = "CREATOR_PER_ID")
    private int creatorPerId;
    @Column(name = "APPROVER_PER_ID")
    private int approverPerId;    
    @Column(name = "ACTIVE")
    private Character active;    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
    @JsonIgnore
    @OneToMany(mappedBy = "trainingId")
    private Collection<TrainingActivity> trainingActivitieCollection;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getGoals() {
        return goals;
    }

    public short getWeeks() {
        return weeks;
    }

    public short getDays() {
        return days;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public int getCreatorPerId() {
        return creatorPerId;
    }

    public int getApproverPerId() {
        return approverPerId;
    }

    public Character getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Collection<TrainingActivity> getTrainingActivitieCollection() {
        return trainingActivitieCollection;
    }
    
    
}
