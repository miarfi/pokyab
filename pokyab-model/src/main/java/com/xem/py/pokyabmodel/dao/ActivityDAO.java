
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Activity;
import java.util.List;

/**
 *
 * @author arria
 */
public interface ActivityDAO {
    boolean Add(Activity activity);
    
    List<Activity> getActiveActivities();
    List<Activity> getAllActivities();
}
