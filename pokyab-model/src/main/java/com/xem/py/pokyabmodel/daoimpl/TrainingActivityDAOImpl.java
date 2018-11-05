
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
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
@Repository("trainingActivityDAO")
@Transactional

public class TrainingActivityDAOImpl implements TrainingActivityDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public boolean Add(TrainingActivity trainingActivity) {
        try {
            sessionFactory.getCurrentSession()
                          .persist(trainingActivity);            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public List<TrainingActivity> getActiveTrainActivities() {
        String query = "FROM TrainingActivity";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivity.class)
                .getResultList();
    }

    @Override
    public List<TrainingActivity> getAllTrainActivities() {
        String query = "FROM TrainingActivity";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivity.class)
                .getResultList();
    }
    
}
