package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Team;
import com.xem.py.pokyabmodel.view.TeamV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TeamDAO {
    boolean add(Team team);
    boolean update(Team team);
    boolean delete(Team team);
    
    List<Team> getActiveTeams(); 
    List<Team> getAllTeams();    
    List<TeamV> getAllTeamsV(); 
    Team getTeamById(int id);
}
