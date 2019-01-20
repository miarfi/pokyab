
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.Team;
import com.xem.py.pokyabmodel.view.TeamV;
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
@Repository("teamDAO")
@Transactional
public class TeamDAOImpl implements TeamDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public boolean add(Team team) {
        try {
            team.setActive('Y');
            sessionFactory.getCurrentSession()
                    .persist(team);
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    @Override
    public boolean update(Team team) {        
        try {            
            sessionFactory.getCurrentSession()
                    .update(team);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Team team) {
        try {     
//            team.setActive('N');
            team.setEndDate(new java.sql.Date(System.currentTimeMillis()));
            sessionFactory.getCurrentSession()
                    .delete(team);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<Team> getActiveTeams() {
        String query = "FROM Team WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Team.class)
                .getResultList();
    }

    @Override
    public List<Team> getAllTeams() {
        String query = "FROM Team";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Team.class)
                .getResultList();
    }

    @Override
    public List<TeamV> getAllTeamsV() {
        String query = "FROM TeamV";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TeamV.class)
                .getResultList();
    }
    
    @Override
    public Team getTeamById(int id) {
        String query = "FROM Team WHERE teamId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Team.class)
                .setParameter("id", id)
                .getSingleResult();
    }  
}