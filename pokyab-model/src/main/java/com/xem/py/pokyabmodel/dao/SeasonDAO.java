package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Season;
import java.util.List;

/**
 *
 * @author arria
 */
public interface SeasonDAO {
    boolean Add(Season season);
    
    List<Season> getActiveSeasons();
    List<Season> getAllSeasons();
}
