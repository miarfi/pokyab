package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.TrainingActivity;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TrainingActivityDAO {
    boolean Add(TrainingActivity trainingActivity);
    
    List<TrainingActivity> getActiveTrainActivities();
    List<TrainingActivity> getAllTrainActivities(); 
}
