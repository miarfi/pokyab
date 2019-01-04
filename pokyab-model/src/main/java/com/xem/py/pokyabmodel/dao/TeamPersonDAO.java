
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.TeamPerson;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TeamPersonDAO {
    boolean Add(TeamPerson teamPerson);
    boolean update(TeamPerson teamPerson);
    boolean delete(TeamPerson teamPerson);
    List<TeamPerson> getActiveTeamPersons();
    List<TeamPerson> getAllTeamPersons();  
}
