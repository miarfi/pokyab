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
public class SeasonTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEASON_TEAM_ID")
    private int seasonTeamId;
    @Column(name = "SEASON_ID")
    private int seasonId;
    @Column(name = "TEAM_ID")
    private int teamId;

    public SeasonTeam() {
    }

    public int getSeasonTeamId() {
        return seasonTeamId;
    }

    public void setSeasonTeamId(int seasonTeamId) {
        this.seasonTeamId = seasonTeamId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
