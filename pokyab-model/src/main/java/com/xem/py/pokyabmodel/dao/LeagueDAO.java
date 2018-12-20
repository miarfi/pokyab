package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.League;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LeagueDAO {
    boolean add(League league);
    boolean update(League league);
    boolean delete(League league);
    
    List<League> getActiveLeagues();
    List<League> getAllLeagues();
    League getLeagueById(int id);
}
