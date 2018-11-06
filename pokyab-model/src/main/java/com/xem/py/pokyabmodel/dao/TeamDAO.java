package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Team;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TeamDAO {
    boolean Add(Team team);
    
    List<Team> getActiveTeams(); 
    List<Team> getAllTeams();     
}
