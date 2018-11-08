
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Training;
import java.util.List;

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
    public boolean add(Training training) {
        try {
//            training.setActive('Y');
//            training.setStatusCode("NEW");
            sessionFactory.getCurrentSession()
                          .persist(training);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public boolean update(Training training) {
        try {            
            sessionFactory.getCurrentSession()
                          .update(training);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public boolean delete(Training training) {
        try {  
            training.setActive('N');
            training.setEndDate(new java.sql.Date(System.currentTimeMillis()));
            sessionFactory.getCurrentSession()
                          .update(training);            
        } catch (Exception e) {
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
