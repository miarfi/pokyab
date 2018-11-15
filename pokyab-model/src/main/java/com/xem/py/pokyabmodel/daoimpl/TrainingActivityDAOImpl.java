package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
import com.xem.py.pokyabmodel.view.TrainingActivityV;
import java.util.List;

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

public class TrainingActivityDAOImpl implements TrainingActivityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(TrainingActivity trainingActivity) {
        try {
            sessionFactory.getCurrentSession()
                    .persist(trainingActivity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(TrainingActivity trainingActivity) {
        try {            
            sessionFactory.getCurrentSession()
                    .update(trainingActivity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TrainingActivity trainingActivity) {
        try {     
            //Pendiente definir valores para desactivar
            sessionFactory.getCurrentSession()
                    .update(trainingActivity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //ToDo no tiene el parametro active
    @Override
    public List<TrainingActivity> getActiveTrainActivities(int id) {
        String query = "FROM TrainingActivity WHERE trainingId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivity.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<TrainingActivity> getAllTrainActivByTrainId(int id) {
        String query = "FROM TrainingActivity WHERE trainingId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivity.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<TrainingActivityV> getAllTrainActivVByTrainId(int id) {
        String query = "FROM TrainingActivityV WHERE trainingId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivityV.class)
                .setParameter("id", id)
                .getResultList();
    }
    
    @Override
    public TrainingActivity getTrainActivityById(int id) {
          String query = "FROM TrainingActivity WHERE trainActId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TrainingActivity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
