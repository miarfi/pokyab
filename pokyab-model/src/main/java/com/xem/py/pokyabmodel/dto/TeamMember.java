package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "TEAM_MEMBERS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TeamMember.findAll", query = "SELECT t FROM TeamMember t")})
public class TeamMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAM_MEMBER_ID")
    private Long teamMemberId;
    @Basic(optional = false)
    @Column(name = "TEAM_ID")
    private long teamId;
    @Basic(optional = false)
    @Column(name = "PERSON_ID")
    private long personId;
    @Column(name = "MEMBER_TYPE_CODE")
    private String memberTypeCode;
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

    public TeamMember() {
    }

//    public TeamMember(Long teamMemberId) {
//        this.teamMemberId = teamMemberId;
//    }
//
//    public TeamMember(Long teamMemberId, long teamId, long personId, Character active, Date startDate) {
//        this.teamMemberId = teamMemberId;
//        this.teamId = teamId;
//        this.personId = personId;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getMemberTypeCode() {
        return memberTypeCode;
    }

    public void setMemberTypeCode(String memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamMemberId != null ? teamMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMember)) {
            return false;
        }
        TeamMember other = (TeamMember) object;
        if ((this.teamMemberId == null && other.teamMemberId != null) || (this.teamMemberId != null && !this.teamMemberId.equals(other.teamMemberId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.TeamMember[ teamMemberId=" + teamMemberId + " ]";
//    }
    
}
