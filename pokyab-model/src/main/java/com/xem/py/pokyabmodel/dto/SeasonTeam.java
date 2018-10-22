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
@Table(name = "SEASON_TEAMS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "SeasonTeam.findAll", query = "SELECT s FROM SeasonTeam s")})
public class SeasonTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEASON_TEAM_ID")
    private Long seasonTeamId;
    @Column(name = "SEASON_ID")
    private Long seasonId;
    @Column(name = "TEAM_ID")
    private Long teamId;

    public SeasonTeam() {
    }

//    public SeasonTeam(Long seasonTeamId) {
//        this.seasonTeamId = seasonTeamId;
//    }

    public Long getSeasonTeamId() {
        return seasonTeamId;
    }

    public void setSeasonTeamId(Long seasonTeamId) {
        this.seasonTeamId = seasonTeamId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seasonTeamId != null ? seasonTeamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeasonTeam)) {
            return false;
        }
        SeasonTeam other = (SeasonTeam) object;
        if ((this.seasonTeamId == null && other.seasonTeamId != null) || (this.seasonTeamId != null && !this.seasonTeamId.equals(other.seasonTeamId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.SeasonTeam[ seasonTeamId=" + seasonTeamId + " ]";
//    }
    
}
