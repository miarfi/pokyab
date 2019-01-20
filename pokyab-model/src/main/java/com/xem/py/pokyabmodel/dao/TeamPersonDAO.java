
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.TeamPerson;
import com.xem.py.pokyabmodel.view.TeamPersonV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TeamPersonDAO {
    boolean add(TeamPerson teamPerson);
    boolean update(TeamPerson teamPerson);
    boolean delete(TeamPerson teamPerson);
    List<TeamPerson> getActiveTeamPersonsByTeam(int teamId);
    List<TeamPersonV> getAllTeamPersonsByTeam(int teamId);  
    TeamPerson getTeamPersonById(int id);
}
