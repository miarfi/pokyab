
package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "LEAGUES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LEAGUE_ID")
    private Long leagueId;
    @Column(name = "LEAGUE_NAME")
    private String leagueName;
    @Column(name = "LEAGUE_TYPE")
    private String leagueType;
    @Column(name = "CATEGORY_CODE")
    private String categoryCode;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "MIN_AGE")
    private Short minAge;
    @Column(name = "MAX_AGE")
    private Short maxAge;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leagueId")
    private Collection<Match> matchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leagueId")
    private Collection<Team> teamCollection;

    public League() {
    }

//    public League(Long leagueId) {
//        this.leagueId = leagueId;
//    }
//
//    public League(Long leagueId, Character active, Date startDate) {
//        this.leagueId = leagueId;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(String leagueType) {
        this.leagueType = leagueType;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Short getMinAge() {
        return minAge;
    }

    public void setMinAge(Short minAge) {
        this.minAge = minAge;
    }

    public Short getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Short maxAge) {
        this.maxAge = maxAge;
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
    public Collection<Match> getMatchCollection() {
        return matchCollection;
    }

    public void setMatchCollection(Collection<Match> matchCollection) {
        this.matchCollection = matchCollection;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leagueId != null ? leagueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        if ((this.leagueId == null && other.leagueId != null) || (this.leagueId != null && !this.leagueId.equals(other.leagueId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.League[ leagueId=" + leagueId + " ]";
//    }
    
}
