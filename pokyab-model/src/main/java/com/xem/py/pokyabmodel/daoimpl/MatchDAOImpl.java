
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.MatchDAO;
import com.xem.py.pokyabmodel.dto.Match;
import com.xem.py.pokyabmodel.view.MatchV;
//import com.xem.py.pokyabmodel.view.MatchV;
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
@Repository("matchDAO")
@Transactional
public class MatchDAOImpl implements MatchDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public boolean add(Match match) {
        try {            
            sessionFactory.getCurrentSession()
                    .persist(match);
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    @Override
    public boolean update(Match match) {        
        try {            
            sessionFactory.getCurrentSession()
                    .update(match);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Match match) {
        try {     
            sessionFactory.getCurrentSession()
                    .delete(match);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<Match> getActiveMatchs() {
        String query = "FROM Match WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Match.class)
                .getResultList();
    }

    @Override
    public List<Match> getAllMatchs() {
        String query = "FROM Match";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Match.class)
                .getResultList();
    }

    @Override
    public List<MatchV> getAllMatchsV() {
        String query = "FROM MatchV";
        return sessionFactory.getCurrentSession()
                .createQuery(query, MatchV.class)
                .getResultList();
    }
    
    @Override
    public Match getMatchById(int id) {
        String query = "FROM Match WHERE matchId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Match.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
