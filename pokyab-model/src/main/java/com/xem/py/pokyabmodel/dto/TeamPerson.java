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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TEAM_PERSONS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TeamPerson.findAll", query = "SELECT t FROM TeamPerson t")})
public class TeamPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAM_PERSON_ID")
    private Long teamPersonId;
    @Column(name = "PERSON_ID")
    private Long personId;
    @Column(name = "MEMBER_TYPE")
    private String memberType;
    @Basic(optional = false)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;
    @Basic(optional = false)
    @Column(name = "POSITION_CODE")
    private String positionCode;
    @Column(name = "PHISIC_CODE")
    private String phisicCode;
    @Basic(optional = false)
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "AGE")
    private Short age;
    @Column(name = "HEIGHT")
    private Short height;
    @Column(name = "WEIGHT")
    private Short weight;
    @Column(name = "PLAYER_NUMBER")
    private Short playerNumber;
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
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID")
    @ManyToOne(optional = false)
    private Team teamId;
    @OneToMany(mappedBy = "personId")
    private Collection<TrainingPerson> trainingPersonCollection;

    public TeamPerson() {
    }

//    public TeamPerson(Long teamPersonId) {
//        this.teamPersonId = teamPersonId;
//    }
//
//    public TeamPerson(Long teamPersonId, String fullName, Date birthDate, String positionCode, String statusCode, Character active, Date startDate) {
//        this.teamPersonId = teamPersonId;
//        this.fullName = fullName;
//        this.birthDate = birthDate;
//        this.positionCode = positionCode;
//        this.statusCode = statusCode;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getTeamPersonId() {
        return teamPersonId;
    }

    public void setTeamPersonId(Long teamPersonId) {
        this.teamPersonId = teamPersonId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPhisicCode() {
        return phisicCode;
    }

    public void setPhisicCode(String phisicCode) {
        this.phisicCode = phisicCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public Short getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Short playerNumber) {
        this.playerNumber = playerNumber;
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

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    @XmlTransient
    public Collection<TrainingPerson> getTrainingPersonCollection() {
        return trainingPersonCollection;
    }

    public void setTrainingPersonCollection(Collection<TrainingPerson> trainingPersonCollection) {
        this.trainingPersonCollection = trainingPersonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamPersonId != null ? teamPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamPerson)) {
            return false;
        }
        TeamPerson other = (TeamPerson) object;
        if ((this.teamPersonId == null && other.teamPersonId != null) || (this.teamPersonId != null && !this.teamPersonId.equals(other.teamPersonId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.TeamPerson[ teamPersonId=" + teamPersonId + " ]";
//    }
    
}
