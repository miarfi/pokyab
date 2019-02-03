
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Match;
import com.xem.py.pokyabmodel.view.MatchV;
//import com.xem.py.pokyabmodel.view.MatchV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface MatchDAO {
    boolean add(Match match);
    boolean update(Match match);
    boolean delete(Match match);
    
    List<Match> getActiveMatchs(); 
    List<Match> getAllMatchs();    
    List<MatchV> getAllMatchsV(); 
    Match getMatchById(int id);
}
