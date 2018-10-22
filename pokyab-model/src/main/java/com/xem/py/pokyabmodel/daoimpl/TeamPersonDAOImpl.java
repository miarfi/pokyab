package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TeamPersonDAO;
import com.xem.py.pokyabmodel.dto.TeamPerson;
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
@Repository("TeamPersonDAO")
@Transactional
public class TeamPersonDAOImpl implements TeamPersonDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    public boolean Add(TeamPerson teamPerson) {
        
        try {
            teamPerson.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                    .persist(teamPerson);
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public List<TeamPerson> getActiveTeamPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
