package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Location;
import com.xem.py.pokyabmodel.view.LocationV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LocationDAO {
    boolean add(Location location);
    boolean update(Location location);
    boolean delete(Location location);
    List<Location> getActiveLocations();
    List<LocationV> getAllLocationsV();   
    Location getLocationById(int id); 
}
