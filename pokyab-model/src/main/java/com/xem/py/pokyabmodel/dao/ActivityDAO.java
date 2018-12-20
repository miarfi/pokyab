
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.view.ActivityV;
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
    List<ActivityV> getAllActivitiesV();
    Activity getActivityById(int id);

}
