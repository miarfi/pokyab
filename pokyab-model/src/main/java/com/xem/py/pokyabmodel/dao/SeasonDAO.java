package com.xem.py.pokyabmodel.dao;


import com.xem.py.pokyabmodel.dto.Season;
import java.util.List;

/**
 *
 * @author arria
 */
public interface SeasonDAO {
    boolean add(Season season);
    boolean update(Season season);
    boolean delete(Season season);
    
    List<Season> getActiveSeasons();
    List<Season> getAllSeasons();
    Season getSeasonById(int id);
}
