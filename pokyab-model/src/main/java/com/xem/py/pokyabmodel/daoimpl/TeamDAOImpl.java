
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.Team;
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

    public boolean Add(Team team) {

        try {
            team.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                    .persist(team);
        } catch (HibernateException e) {
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
    
}
