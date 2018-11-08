package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dto.Season;
import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("seasonDAO")
@Transactional
public class SeasonDAOImpl implements SeasonDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean Add(Season season) {
        try {           
            sessionFactory.getCurrentSession()
                          .persist(season);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public List<Season> getActiveSeasons() {
        String query = "FROM Season";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Season.class)                                     
                             .getResultList();
    }

    @Override
    public List<Season> getAllSeasons() {
        String query = "FROM Season";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Season.class)                                     
                             .getResultList();
    }
    
}
