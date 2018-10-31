package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.League;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LeagueDAO {
    boolean Add(League league);
    
    List<League> getActiveLeagues();
    List<League> getAllLeagues();
}
