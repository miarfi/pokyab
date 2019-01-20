package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TeamPersonDAO;
import com.xem.py.pokyabmodel.dto.TeamPerson;
import com.xem.py.pokyabmodel.view.TeamPersonV;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("TeamPersonDAO")
@Transactional
public class TeamPersonDAOImpl implements TeamPersonDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    public boolean add(TeamPerson teamPerson) {
        
        try {
            teamPerson.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                    .persist(teamPerson);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
    @Override
    public boolean update(TeamPerson teamPerson) {
        try {            
            sessionFactory.getCurrentSession()
                    .update(teamPerson);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TeamPerson teamPerson) {
        try {                
            sessionFactory.getCurrentSession()
                    .delete(teamPerson);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<TeamPerson> getActiveTeamPersonsByTeam(int teamId) {
        String query = "FROM TeamPerson WHERE active = 'Y' and teamId = :teamId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TeamPerson.class)
                .setParameter("teamId", teamId)
                .getResultList();
    }



    @Override
    public List<TeamPersonV> getAllTeamPersonsByTeam(int teamId) {
        String query = "FROM TeamPersonV WHERE teamId = :teamId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TeamPersonV.class)
                .setParameter("teamId", teamId)
                .getResultList();
    }

    @Override
    public TeamPerson getTeamPersonById(int id) {
        String query = "FROM TeamPerson WHERE teamPersonId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TeamPerson.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
