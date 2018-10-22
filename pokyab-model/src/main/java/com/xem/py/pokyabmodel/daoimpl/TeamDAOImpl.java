
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
@Repository("TeamDAO")
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

    public List<Team> getActiveTeams() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
