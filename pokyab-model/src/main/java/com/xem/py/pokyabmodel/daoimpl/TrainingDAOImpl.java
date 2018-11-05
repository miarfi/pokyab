
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Training;
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
@Repository("trainingDAO")
@Transactional
public class TrainingDAOImpl implements TrainingDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean Add(Training training) {
        try {
            sessionFactory.getCurrentSession()
                          .persist(training);            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public List<Training> getActiveTrainings() {
        String query = "FROM Training";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Training.class)
                .getResultList();
    }

    @Override
    public List<Training> getAllTrainings() {
        String query = "FROM Training";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Training.class)
                .getResultList();
    }

    @Override
    public Training getTrainingById(int id) {
        String query = "FROM Training WHERE trainingId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Training.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
