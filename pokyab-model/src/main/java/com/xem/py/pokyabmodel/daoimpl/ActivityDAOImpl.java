package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dto.Activity;
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
@Repository("activityDAO")
@Transactional
public class ActivityDAOImpl implements ActivityDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean Add(Activity activity) {
        try {
            sessionFactory.getCurrentSession()
                          .persist(activity);            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public List<Activity> getActiveActivities() {
        String query = "FROM Activity";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Activity.class)
                .getResultList();
    }

    @Override
    public List<Activity> getAllActivities() {
        String query = "FROM Activity";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Activity.class)
                .getResultList();
    }
    
}
