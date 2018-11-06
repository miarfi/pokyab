package com.xem.py.pokyabmodel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "SEASONS")
public class Season implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEASON_ID")
    private int seasonId;
    @Basic(optional = false)
    @Column(name = "SEASON_NAME")
    private String seasonName;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "SEASON_CODE")
    private String seasonCode;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seasonId")
    private Collection<Match> matchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seasonId")
    private Collection<Team> teamCollection;

    public Season() {
        this.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        this.setEndDate(new java.sql.Date(System.currentTimeMillis()));
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(String seasonCode) {
        this.seasonCode = seasonCode;
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
}
