package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import java.util.List;

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
    public boolean add(Activity activity) {
        try {

            sessionFactory.getCurrentSession()
                          .persist(activity);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }
    
    @Override
    public boolean update(Activity activity) {
        try {              
            sessionFactory.getCurrentSession()
                          .update(activity);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public boolean delete(Activity activity) {
        try {       
            activity.setActive('N');
            activity.setEndDate(new java.sql.Date(System.currentTimeMillis()));  
            sessionFactory.getCurrentSession()
                          .update(activity);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }
    
    @Override
    public List<Activity> getActiveActivities() {
        String query = "FROM Activity WHERE active = 'Y'";
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

    @Override
    public Activity getActivityById(int id) {
        String query = "FROM Activity WHERE activityId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Activity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
