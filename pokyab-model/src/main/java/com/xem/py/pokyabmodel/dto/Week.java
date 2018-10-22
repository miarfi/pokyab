package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "WEEKS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Week.findAll", query = "SELECT w FROM Week w")})
public class Week implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WEEK_ID")
    private Long weekId;
    @Basic(optional = false)
    @Column(name = "WEEK_NUMBER")
    private short weekNumber;
    @Column(name = "SEASON_ID")
    private Long seasonId;

    public Week() {
    }

//    public Week(Long weekId) {
//        this.weekId = weekId;
//    }
//
//    public Week(Long weekId, short weekNumber) {
//        this.weekId = weekId;
//        this.weekNumber = weekNumber;
//    }

    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }

    public short getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(short weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weekId != null ? weekId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Week)) {
            return false;
        }
        Week other = (Week) object;
        if ((this.weekId == null && other.weekId != null) || (this.weekId != null && !this.weekId.equals(other.weekId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Week[ weekId=" + weekId + " ]";
//    }
    
}
