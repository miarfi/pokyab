package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.TrainingActivity;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TrainingActivityDAO {
    boolean add(TrainingActivity trainingActivity);
    boolean update(TrainingActivity trainingActivity);
    boolean delete(TrainingActivity trainingActivity);
    
    List<TrainingActivity> getActiveTrainActivities(int id);
    List<TrainingActivity> getAllTrainActivByTrainId(int id); 
    TrainingActivity getTrainActivityById(int id);

}
