package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Training;
import java.util.List;

/**
 *
 * @author arria
 */
public interface TrainingDAO {
    boolean Add(Training training);
    
    List<Training> getActiveTrainings();
    List<Training> getAllTrainings(); 
}
