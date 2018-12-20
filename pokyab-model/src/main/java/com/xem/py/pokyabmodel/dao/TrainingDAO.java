package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Training;
import com.xem.py.pokyabmodel.view.TrainingV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TrainingDAO {
    boolean add(Training training); 
    boolean update(Training training);    
    boolean delete(Training training);
    
    List<Training> getActiveTrainings();
    List<Training> getAllTrainings(); 
    List<TrainingV> getAllTrainingsV(); 
    Training getTrainingById(int id);

}
