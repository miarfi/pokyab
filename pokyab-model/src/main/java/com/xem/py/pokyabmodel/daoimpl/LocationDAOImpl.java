
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LocationDAO;
import com.xem.py.pokyabmodel.dto.Location;
import com.xem.py.pokyabmodel.view.LocationV;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("locationDAO")
@Transactional
public class LocationDAOImpl implements LocationDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override    
    public boolean add(Location location) {        
        try {            
            sessionFactory.getCurrentSession()
                          .persist(location);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
        
    }

    @Override
    public boolean update(Location location) {
        try {             
            sessionFactory.getCurrentSession()
                          .update(location);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(Location location) {
        try { 
            sessionFactory.getCurrentSession()
                          .delete(location);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    @Override
    public List<Location> getActiveLocations() {
        String query = "FROM Location WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Location.class)                                     
                             .getResultList();
    }
    

    @Override
    public List<LocationV> getAllLocationsV() {
        String query = "FROM LocationV";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, LocationV.class)                                     
                             .getResultList();
    }
    
    @Override
    public Location getLocationById(int id) {
        String query = "FROM Location WHERE locationId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Location.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
