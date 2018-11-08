
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Activity;
import java.util.List;

/**
 *
 * @author arria
 */
public interface ActivityDAO {
    boolean add(Activity activity);
    boolean update(Activity activity);
    boolean delete(Activity activity);
    
    List<Activity> getActiveActivities();
    List<Activity> getAllActivities();
    Activity getActivityById(int id);

}
