package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dto.League;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("leagueDAO")
@Transactional
public class LeagueDAOImpl implements LeagueDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean Add(League league) {
        try {
            sessionFactory.getCurrentSession()
                    .persist(league);
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<League> getActiveLeagues() {
        String query = "FROM League WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                .createQuery(query, League.class)
                .getResultList();
    }

    @Override
    public List<League> getAllLeagues() {
        String query = "FROM League";
        return sessionFactory.getCurrentSession()
                .createQuery(query, League.class)
                .getResultList();
    }
    
}
